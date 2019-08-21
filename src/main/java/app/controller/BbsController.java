package app.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.BbsModel;
import app.repository.BbsRepo;
import app.service.BbsService;

@RestController
@CrossOrigin("origin-allowed=*")
@RequestMapping(value = "/bbs")
public class BbsController {

    @Autowired
    BbsService bbsService;

    @Autowired
    BbsRepo bbsRepo;

    @RequestMapping(value = { "", "/", "/{idx}" }, method = RequestMethod.GET)
    public Page<BbsModel> list(@PathVariable Optional<Integer> idx) {
        Pageable pageable = PageRequest.of(idx.orElse(1) - 1, 10, new Sort(Direction.DESC, "idx"));
        Page<BbsModel> page = bbsRepo.findAll(pageable);
        return page;
    }

    @RequestMapping(value = "/read/{idx}", method = RequestMethod.GET)
    public BbsModel read(@PathVariable int idx) {
        BbsModel bm = bbsService.read(idx);
        return bm;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> insert(@RequestBody BbsModel bbsModel) {
        Map<String, String> map = new HashMap<String, String>();
        bbsService.create(bbsModel);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody BbsModel bbsModel, @PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String message = bbsService.update(bbsModel,idx) ? "success" : "fail";
        map.put("message", message);
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody BbsModel bbsModel, @PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String message = bbsService.delete(bbsModel,idx) ? "success" : "fail";
        map.put("message", message);
        return map;
    }
}