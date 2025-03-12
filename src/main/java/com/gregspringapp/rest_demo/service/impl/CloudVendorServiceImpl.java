package com.gregspringapp.rest_demo.service.impl;

import com.gregspringapp.rest_demo.exception.CloudVendorNotFoundException;
import com.gregspringapp.rest_demo.model.CloudVendor;
import com.gregspringapp.rest_demo.repository.CloudVendorRepository;
import com.gregspringapp.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return cloudVendorRepository
                .findById(cloudVendorId).orElseThrow(() -> new CloudVendorNotFoundException("Cloud vendor not found for ID: " + cloudVendorId));
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        List<CloudVendor> allCloudVendors = cloudVendorRepository.findAll();
//        return List.of();
        return allCloudVendors;
    }
}
