package rayboc.rayboc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rayboc.rayboc.entity.AggregationLogEntity;

@Repository
public interface AggregationLogRepository extends JpaRepository<AggregationLogEntity, Integer> {
	
	List<AggregationLogEntity> findByAccessTokenIn(List<String> queryList);

}
