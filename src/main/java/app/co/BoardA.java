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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.mo.BoardM;
import app.repo.BoardR;
import app.se.BoardS;

@RestController
@RequestMapping(value="/board")
public class BoardA {

    @Autowired
	BoardS bs;
	
	@Autowired
    BoardR br;
    
    @RequestMapping(value={"","/","/{index}"}, method=RequestMethod.GET)
    public Page<BoardM> list(@PathVariable Optional<Integer> index) {
        Pageable pageable = PageRequest.of(index.orElse(1)-1,10,new Sort(Direction.DESC,"idx"));
        Page<BoardM> page = br.findAll(pageable);
        return page;
    }

    @RequestMapping(value={"/read/{index}"}, method=RequestMethod.GET)
    public BoardM read(@PathVariable int index){
        BoardM bm = bs.read(index);
        return bm;
    }

    @RequestMapping(value={"/insert"},method=RequestMethod.POST)
    public Map<String,String> insert(BoardM bm){
        Map<String,String> map = new HashMap<String,String>();
        bs.create(bm);
        map.put("message", "success");
        return map;
    }
    
    @RequestMapping(value={"/update"},method=RequestMethod.PUT)
    public Map<String,String> update(BoardM bm){
        Map<String,String> map = new HashMap<String,String>();
        String ms = bs.update(bm)?"fail":"success";
        map.put("message",ms);
        return map;
    }

    @RequestMapping(value={"/delete"},method=RequestMethod.DELETE)
    public Map<String,String> delete(BoardM bm){
        Map<String,String> map = new HashMap<String,String>();
        String ms = bs.delete(bm)?"fail":"success";
        map.put("message",ms);
        return map;
    }
}