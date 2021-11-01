package model.service.Impl;

import model.repository.Impl.ServiceRepoImpl;
import model.repository.ServiceRepo;
import model.service.Service;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {
    private ServiceRepo serviceRepo=new ServiceRepoImpl();
    @Override
    public List<model.bean.Service> findAll() {
        return this.serviceRepo.findAll();
    }

    @Override
    public Map<String,String> create(model.bean.Service service) {
        Map<String,String> stringMap=new HashMap<>();
        if(Validate.validateServiceID(service.getService_id())!=null
                ||Validate.validateCost(service.getService_cost())!=null
                ||Validate.validateNumberOfFloors(service.getNumber_of_floor())!=null){
            stringMap.put("service_id",Validate.validateServiceID(service.getService_id()));
            stringMap.put("service_cost",Validate.validateCost(service.getService_cost()));
            stringMap.put("number_of_floor",Validate.validateNumberOfFloors(service.getNumber_of_floor()));
        }else {
            this.serviceRepo.create(service);
        }
        return stringMap;
    }
}
