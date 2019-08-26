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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.bbs.Bbs_EconomyModel;
import app.repository.bbs.Bbs_EconomyRepo;
import app.service.impl.Bbs_EconomyServiceimpl;

@RestController
@CrossOrigin("origin-allowed=*")
@RequestMapping(value = "/bbseconomy")
public class Bbs_EconomyController {

    @Autowired
    Bbs_EconomyServiceimpl bbs_EconomyService;

    @Autowired
    Bbs_EconomyRepo bbs_EconomyRepo;
    // {"", "/", "/{idx}}" 경우 수를 세가지 두는것
    @RequestMapping(value = { "", "/", "/{idx}" }, method = RequestMethod.GET)
    public Page<Bbs_EconomyModel> list(@PathVariable Optional<Integer> idx) {
        Pageable pageable = PageRequest.of(idx.orElse(1) - 1, 10, new Sort(Direction.DESC, "idx"));
        Page<Bbs_EconomyModel> page = bbs_EconomyRepo.findAll(pageable);
        return page;
    }

    @RequestMapping(value = "/read/{idx}", method = RequestMethod.GET)
    public Bbs_EconomyModel read(@PathVariable int idx) {
        Bbs_EconomyModel bm = bbs_EconomyService.read(idx);
        return bm;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> insert(@RequestBody Bbs_EconomyModel bm) {
        Map<String, String> map = new HashMap<String, String>();
        bbs_EconomyService.create(bm);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody Bbs_EconomyModel bm, @PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String message = bbs_EconomyService.update(bm,idx) ? "success" : "fail";
        map.put("message", message);
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody Bbs_EconomyModel bm, @PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String message = bbs_EconomyService.delete(bm,idx) ? "success" : "fail";
        map.put("message", message);
        return map;
    }
}