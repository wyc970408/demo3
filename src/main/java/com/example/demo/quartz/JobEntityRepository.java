package com.example.demo.quartz;

import org.springframework.data.repository.CrudRepository;

public interface JobEntityRepository extends CrudRepository {
    JobEntity getById(Integer id);
}
