package net.websnet.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.websnet.controller.HomeController;
import net.websnet.domain.GuestVO;
import net.websnet.mapper.GuestMapper;

@Service ///GuestImpl 을 service 로 인식해달라
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
@Setter(onMethod_=@Autowired)
private GuestMapper mapper;

@Override
public List<GuestVO> guestList(){
	log.info("guestList().....");
	return mapper.guestList();	
}
	
	
}
