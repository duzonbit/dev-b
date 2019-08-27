package app.controller.bbs;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.bbs.BbsModel;
import app.repository.bbs.BbsRepo;
import app.service.impl.BbsServiceimpl;

/**
 * bbsController
 */
@RestController
@CrossOrigin("origin-allowed=*")
@RequestMapping(value = "/bbs")
public class bbsController {

    @Autowired
    BbsServiceimpl bbsServiceimpl;

    @Autowired
    BbsRepo bbsRepo;

    @GetMapping(value = { "", "/", "/{index}" })
    public Page<BbsModel> list(@PathVariable Optional<Integer> index) { // URL에 index가 안들어와도 인식하게하는것
        Pageable pageable = PageRequest.of(index.orElse(1) - 1, 10, new Sort(Direction.DESC, "idx"));
        Page<BbsModel> page = bbsRepo.findAll(pageable);
        return page;
    }

    @GetMapping(value = { "/read/{index}" })
    public BbsModel read(@PathVariable int index) {
        BbsModel bbsModel = bbsServiceimpl.read(index);
        return bbsModel;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> insert(@RequestBody BbsModel bbsModel) {
        Map<String, String> map = new HashMap<String, String>();
        bbsServiceimpl.create(bbsModel);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody BbsModel bbsModel,@PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String ms = bbsServiceimpl.update(bbsModel) ? "success" : "fail";
        map.put("message", ms);
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody BbsModel bbsModel,@PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String ms = bbsServiceimpl.delete(bbsModel) ? "success" : "fail";
        map.put("message", ms);
        return map;
    }
}
