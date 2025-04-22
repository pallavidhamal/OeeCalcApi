/*
 * package com.oee.serviceimpl;
 * 
 * import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.oee.dto.UnitDto; import com.oee.dto.incoming.UnitIncomingDto;
 * import com.oee.dto.mapper.UnitMapper; import com.oee.entity.UnitEntity;
 * import com.oee.exception.BRSException; import com.oee.exception.EntityType;
 * import com.oee.exception.ExceptionType; import
 * com.oee.repository.UnitRepository; import com.oee.service.UnitService; import
 * com.oee.util.AuthenticationService;
 * 
 * @Service public class UnitServiceImpl implements UnitService {
 * 
 * @Autowired UnitRepository unitRepository;
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(UnitServiceImpl.class);
 * 
 * 
 * @Override public List<UnitDto> getAllUnits() {
 * 
 * // TODO Auto-generated method stub
 * //logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
 * 
 * List<UnitEntity> unitEntityList = unitRepository.findAll();
 * 
 * if (unitEntityList == null) { throw
 * BRSException.throwException("Unit List does not exist"); }
 * 
 * return UnitMapper.toUnitDtoList(unitEntityList);
 * 
 * }
 * 
 * @Override public UnitEntity getUnitByID(String fittingTypeID) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public boolean addUnit(UnitIncomingDto unitIncomingDto) { // TODO
 * Auto-generated method stub
 * 
 * 
 * if (unitIncomingDto.getUnitcode() == "") {
 * 
 * throw BRSException.throwException(EntityType.ITEMCODE,
 * ExceptionType.BLANK_VALUE, "Unit Code"); } if (unitIncomingDto.getUnitdesc()
 * == "") {
 * 
 * throw BRSException.throwException(EntityType.ITEMDESC,
 * ExceptionType.BLANK_VALUE, "Unit Desc"); }
 * 
 * UnitEntity unitEntity = new UnitEntity();
 * unitEntity.setUnitcode(unitIncomingDto.getUnitcode());
 * unitEntity.setUnitdesc(unitIncomingDto.getUnitdesc());
 * unitEntity.setIsdeleted("N");
 * 
 * unitEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
 * 
 * unitRepository.save(unitEntity);
 * 
 * logger.info("--- Unit Added Successfully ----");
 * 
 * return true;
 * 
 * }
 * 
 * @Override public boolean editUnit(UnitIncomingDto unitIncomingDto) { // TODO
 * Auto-generated method stub return false; }
 * 
 * @Override public boolean deleteUnit(String unitid) { // TODO Auto-generated
 * method stub return false; }
 * 
 * }
 */