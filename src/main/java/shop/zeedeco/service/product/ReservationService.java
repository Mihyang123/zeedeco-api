package shop.zeedeco.service.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.zeedeco.dao.CustomDao;
import shop.zeedeco.exception.BadRequestException;

@Service
@RequiredArgsConstructor
public class ReservationService {
	
	private final CustomDao dao;
	
	public void addReservation(Map<String, Object> requestMap) throws Exception {
		int effectRow = this.dao.dbInsert("reservation.addReservation", requestMap);
		if ( effectRow < 0 ) new BadRequestException("���忡 �����߽��ϴ�."); 
	}
	
	public void setReservation(Map<String, Object> requestMap) throws Exception {
		int effectRow = this.dao.dbUpdate("reservation.setReservation", requestMap);
		if ( effectRow < 0 ) new BadRequestException("���忡 �����߽��ϴ�."); 
	}
	
	public void logicalRemoveReservation(Map<String, Object> requestMap) throws Exception {
		int effectRow = this.dao.dbUpdate("reservation.setReservation", requestMap);
		if ( effectRow < 0 ) new BadRequestException("���� ������ �����߽��ϴ�."); 
	}
	
	public void physicalRemoveReservation(int reservationSeq) throws Exception {
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("reservationSeq", reservationSeq);
		int effectRow = this.dao.dbInsert("reservation.removeReservation", requestMap);
		if ( effectRow < 0 ) new BadRequestException("������ ������ �����߽��ϴ�."); 
	}
}
