package com.demo.springcloud.controll;

import com.demo.springcloud.entities.Dept;
import com.demo.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptControll {

    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }

    @RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (int i = 0; i < instances.size(); i++) {
            ServiceInstance serviceInstance =  instances.get(i);
            System.out.println(serviceInstance.getServiceId() + "\t"
                + serviceInstance.getHost() + "\t" + serviceInstance.getUri());
        }
        return discoveryClient;
    }
}
