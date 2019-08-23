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

import app.model.bbs.Bbs_EntertainModel;
import app.repository.bbs.Bbs_EntertainRepo;
import app.service.impl.Bbs_EntertainServiceimpl;

@RestController
@CrossOrigin("origin-allowed=*")
@RequestMapping(value = "/bbsentertain")
public class Bbs_EntertainController {

    @Autowired
    Bbs_EntertainServiceimpl bbs_EntertainService;

    @Autowired
    Bbs_EntertainRepo bbs_EntertainRepo;

    @RequestMapping(value = { "", "/", "/{idx}" }, method = RequestMethod.GET)
    public Page<Bbs_EntertainModel> list(@PathVariable Optional<Integer> idx) {
        Pageable pageable = PageRequest.of(idx.orElse(1) - 1, 10, new Sort(Direction.DESC, "idx"));
        Page<Bbs_EntertainModel> page = bbs_EntertainRepo.findAll(pageable);
        return page;
    }

    @RequestMapping(value = "/read/{idx}", method = RequestMethod.GET)
    public Bbs_EntertainModel read(@PathVariable int idx) {
        Bbs_EntertainModel bm = bbs_EntertainService.read(idx);
        return bm;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> insert(@RequestBody Bbs_EntertainModel bm) {
        Map<String, String> map = new HashMap<String, String>();
        bbs_EntertainService.create(bm);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody Bbs_EntertainModel bm, @PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String message = bbs_EntertainService.update(bm,idx) ? "success" : "fail";
        map.put("message", message);
        return map;
    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody Bbs_EntertainModel bm, @PathVariable Optional<Integer> idx) {
        Map<String, String> map = new HashMap<String, String>();
        String message = bbs_EntertainService.delete(bm,idx) ? "success" : "fail";
        map.put("message", message);
        return map;
    }
}