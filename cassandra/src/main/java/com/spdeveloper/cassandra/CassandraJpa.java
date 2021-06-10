package com.spdeveloper.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassandraJpa extends CassandraRepository<Person,String> {
}
