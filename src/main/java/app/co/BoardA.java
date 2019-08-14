package app.co;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.mo.BoardM;
import app.repo.BoardR;
import app.se.BoardS;

@RestController
@CrossOrigin("origin-allowed=*")
@RequestMapping(value="/board")
public class BoardA {

    @Autowired
	BoardS bs;
	
	@Autowired
    BoardR br;
    
    @GetMapping(value={"","/","/{index}"})
    public Page<BoardM> list(@PathVariable Optional<Integer> index) {
        Pageable pageable = PageRequest.of(index.orElse(1)-1,10,new Sort(Direction.DESC,"idx"));
        Page<BoardM> page = br.findAll(pageable);
        return page;
    }

    @GetMapping(value={"/read/{index}"})
    public BoardM read(@PathVariable int index){
        BoardM bm = bs.read(index);
        return bm;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String,String> insert(@RequestBody BoardM bm){
        Map<String,String> map = new HashMap<String,String>();
        bs.create(bm);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String,String> update(@RequestBody BoardM bm){
        Map<String,String> map = new HashMap<String,String>();
        String ms = bs.update(bm)?"success":"fail";
        map.put("message",ms);
        return map;
    }

    @RequestMapping(value={"/"},method=RequestMethod.DELETE)
    public Map<String,String> delete(@RequestBody BoardM bm){
        Map<String,String> map = new HashMap<String,String>();
        String ms = bs.delete(bm)?"success":"fail";
        map.put("message",ms);
        return map;
    }
}