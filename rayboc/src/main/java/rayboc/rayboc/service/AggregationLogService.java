package rayboc.rayboc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rayboc.rayboc.entity.AggregationLogEntity;
import rayboc.rayboc.repository.AggregationLogRepository;

@Service
public class AggregationLogService {
	
	@Autowired
	AggregationLogRepository aggregationLogRepository;
	
	public void execCountLog(List<String> queryList) {
		
//		AggregationLogEntity aggregationLogEntity = aggregationLogRepository.getById(1);
//		System.out.println("test entity: " + aggregationLogEntity.getAccessToken());
		
		List<AggregationLogEntity> aggregationLogList = aggregationLogRepository.findByAccessTokenIn(queryList);
		
		aggregationLogList.forEach(log -> {
			System.out.println("レコード：" + log.getId() + "：" + log.getAccessToken());
		});
	}

}
