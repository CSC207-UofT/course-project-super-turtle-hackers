package com.amigo.course;

// import org.springframework.data.jpa.repository.JpaRepository;


// public interface CourseRepository extends JpaRepository<Course, String>{
// }

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CourseRepository extends ReactiveCosmosRepository<Course, String> {
    Flux<Course> findByTutorial(String tutorial);
}
