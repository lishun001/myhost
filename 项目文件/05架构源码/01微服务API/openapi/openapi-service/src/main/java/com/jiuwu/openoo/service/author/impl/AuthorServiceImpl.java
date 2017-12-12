//package com.jiuwu.openoo.service.author.impl;
//
//
//
//import model.author.CarAuthorPo;
//import model.author.CarCompanyAuthorPo;
//import model.author.CargoAuthorPo;
//import model.author.CargoCompanyAuthorPo;
//import model.user.UserInfoPo;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.stereotype.Service;
//
//import com.danga.MemCached.MemCachedClient;
//import com.jiuwu.openoo.common.openapi.exception.OpenApiBaseException;
//import com.jiuwu.openoo.common.openapi.utils.FileUtil;
//import com.jiuwu.openoo.common.openapi.utils.MessageConstant.FILE_CONSTANT;
//import com.jiuwu.openoo.dao.mapper.author.method.CarAuthorPoMapper;
//import com.jiuwu.openoo.dao.mapper.author.method.CarCompanyAuthorPoMapper;
//import com.jiuwu.openoo.dao.mapper.author.method.CargoAuthorPoMapper;
//import com.jiuwu.openoo.dao.mapper.author.method.CargoCompanyAuthorPoMapper;
//import com.jiuwu.openoo.dao.mapper.user.method.UserInfoPoMapper;
//import com.openapi.model.request.author.CarAuthorRequest;
//import com.openapi.model.request.author.CarCompanyAuthorRequest;
//import com.openapi.model.request.author.CargoAuthorRequest;
//import com.openapi.model.request.author.CargoCompanyAuthorRequest;
//import com.openapi.model.response.author.AuthorResponse;
//
///**
// * 认证关联 实现类
// * @author eason
// *
// */
//@Service("authorService")
//public class AuthorServiceImpl{
//	@Autowired
//	private MessageSource messageSource;
//	// 缓存
//	@Autowired
//	private MemCachedClient memCachedClient;
//	@Autowired
//	private CarAuthorPoMapper carAuthorPoMapper;
//	@Autowired
//	private CarCompanyAuthorPoMapper carCompanyAuthorPoMapper;
//	@Autowired
//	private CargoAuthorPoMapper cargoAuthorPoMapper;
//	@Autowired
//	private CargoCompanyAuthorPoMapper cargoCompanyAuthorPoMapper;
//	@Autowired
//	private UserInfoPoMapper userMapper;
//	
//	/**
//	 * 车主企业认证
//	 */
//	public AuthorResponse addCarCompanyAuthor(CarCompanyAuthorRequest request) throws OpenApiBaseException {
//		AuthorResponse response = new AuthorResponse();
//		String result = null;
//		try {
//			// ①参数验证
//			if (request.getUserId()==null) {
//				result = "申请人不能为空";
//			} else if (StringUtils.isBlank(request.getCompanyName())) {
//				result = "企业名称不能为空";
//			}  else if (StringUtils.isBlank(request.getBusinessNo())) {
//				result = "企业登记号不能未空";
//			} else if (StringUtils.isBlank(request.getLegalPerson())) {
//				result = "法人姓名不能为空";
//			} else if (StringUtils.isBlank(request.getLegalPhone())) {
//				result = "法人电话不能为空";
//			} else if (StringUtils.isBlank(request.getIdCard())) {
//				result = "法人身份证号不能为空";
//			} else if (request.getIdCardPic()==null) {
//				result = "身份证照片不能为空";
//			} else if (request.getBusinessPic()==null) {
//				result = "企业营业执照不能为空";
//			}
//
//			if (StringUtils.isNotBlank(result)) {
//				response.addErrInfo("车主企业认证", result, null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			UserInfoPo userInfoPo = this.userMapper.selectByPrimaryKey(request.getUserId());
//			if(userInfoPo==null){
//				response.addErrInfo("车主企业认证", "该用户不存在！", null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			//一个用户只能认证一次
//			CarCompanyAuthorPo authorPo=this.carCompanyAuthorPoMapper.selectByUserId(request.getUserId());
//			CarCompanyAuthorPo po=null;
//			if(authorPo!=null){
//				if(authorPo.getStatus()==0 || authorPo.getStatus()==1){
//					response.addErrInfo("车主企业认证", "车主企业认证正在认证中！", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				if(authorPo.getStatus()==2){
//					response.addErrInfo("车主企业认证", "车主企业认证已经认证", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				if(authorPo.getStatus()==3){	//认证失败的，不新增记录
//					po=authorPo;
//					po.setUserId(request.getUserId());
//					po.setCompanyName(request.getCompanyName());
//					po.setLegalPerson(request.getLegalPerson());
//					po.setLegalPhone(request.getLegalPhone());
//					po.setBusinessNo(request.getBusinessNo());
//					po.setIdCard(request.getIdCard());
//					po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//					String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setIdCardPic(idCardUrl);
//					String bisPicUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getBusinessPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setBusinessPic(bisPicUrl);
//					this.carCompanyAuthorPoMapper.updateByPrimaryKey(po);
//				}
//			}else{
//				po=new CarCompanyAuthorPo();
//				po.setUserId(request.getUserId());
//				po.setCompanyName(request.getCompanyName());
//				po.setLegalPerson(request.getLegalPerson());
//				po.setLegalPhone(request.getLegalPhone());
//				po.setBusinessNo(request.getBusinessNo());
//				po.setIdCard(request.getIdCard());
//				po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//				String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//				po.setIdCardPic(idCardUrl);
//				String bisPicUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getBusinessPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//				po.setBusinessPic(bisPicUrl);
//				this.carCompanyAuthorPoMapper.insert(po);
//			}
//			response.setStatus(1);
//			return response;
//		} catch (Exception e) {
//			OpenApiBaseException excp = new OpenApiBaseException(e);
//			throw excp;
//		}
//	}
//
//	/**
//	 * 车主个人认证
//	 */
//	public AuthorResponse addCarAuthor(CarAuthorRequest request) throws OpenApiBaseException {
//		AuthorResponse response = new AuthorResponse();
//		String result = null;
//		try {
//			// ①参数验证
//			if (request.getUserId()==null) {
//				result = "申请人不能为空";
//			} else if (request.getCarId()==null) {
//				result = "车辆id不能为空";
//			} else if (StringUtils.isBlank(request.getAuthorName())) {
//				result = "认证姓名不能为空";
//			} else if (StringUtils.isBlank(request.getIdCard())) {
//				result = "身份证号不能为空";
//			} else if (request.getIdCardPic()==null) {
//				result = "身份证照片不能为空";
//			} else if (request.getOperationCardPic()==null) {
//				result = "运营证照片不能为空";
//			} else if (request.getCarCardPic()==null) {
//				result = "驾驶证照片不能为空";
//			}
//
//			if (StringUtils.isNotBlank(result)) {
//				response.addErrInfo("车主个人认证", result, null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			UserInfoPo userInfoPo = this.userMapper.selectByPrimaryKey(request.getUserId());
//			if(userInfoPo==null){
//				response.addErrInfo("车主个人认证", "该用户不存在！", null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			//一个用户只能认证一次
//			CarAuthorPo authorPo=this.carAuthorPoMapper.selectByUserId(request.getUserId());
//			if(authorPo!=null){
//				if(authorPo.getStatus()==0 || authorPo.getStatus()==1){
//					response.addErrInfo("车主个人认证", "车主个人认证正在认证中！", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				if(authorPo.getStatus()==2){
//					response.addErrInfo("车主个人认证", "车主个人认证已经认证", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				if(authorPo.getStatus()==3){	//认证失败的，不新增记录
//					CarAuthorPo po=authorPo;
//					po.setUserId(request.getUserId());
//					po.setCarId(request.getCarId());
//					po.setAuthorName(request.getAuthorName());
//					po.setIdCard(request.getIdCard());
//					po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//					String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setIdCardPic(idCardUrl);
//					
//					String ocPicUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getOperationCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setOperationCardPic(ocPicUrl);
//					
//					String carCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getCarCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setCarCardPic(carCardUrl);
//					this.carAuthorPoMapper.updateByPrimaryKey(po);
//					response.setStatus(1);
//					return response;
//				}
//			}
//			CarAuthorPo po=new CarAuthorPo();
//			po.setUserId(request.getUserId());
//			po.setCarId(request.getCarId());
//			po.setAuthorName(request.getAuthorName());
//			po.setIdCard(request.getIdCard());
//			po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//			String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//			po.setIdCardPic(idCardUrl);
//			
//			String ocPicUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getOperationCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//			po.setOperationCardPic(ocPicUrl);
//			
//			String carCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getCarCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//			po.setCarCardPic(carCardUrl);
//			this.carAuthorPoMapper.insert(po);
//			response.setStatus(1);
//			return response;
//		} catch (Exception e) {
//			OpenApiBaseException excp = new OpenApiBaseException(e);
//			throw excp;
//		}
//	}
//	
//	/**
//	 * 货物企业认证
//	 */
//	public AuthorResponse addCargoCompanyAuthor(CargoCompanyAuthorRequest request) throws OpenApiBaseException {
//		AuthorResponse response = new AuthorResponse();
//		String result = null;
//		try {
//			// ①参数验证
//			if (request.getUserId()==null) {
//				result = "申请人不能为空";
//			} else if (StringUtils.isBlank(request.getCompanyName())) {
//				result = "企业名称不能为空";
//			} else if (StringUtils.isBlank(request.getBusinessNo())) {
//				result = "企业登记号不能未空";
//			} else if (StringUtils.isBlank(request.getLegalPerson())) {
//				result = "法人姓名不能为空";
//			} else if (StringUtils.isBlank(request.getLegalPhone())) {
//				result = "法人电话不能为空";
//			} else if (StringUtils.isBlank(request.getIdCard())) {
//				result = "法人身份证号不能为空";
//			} else if (request.getIdCardPic()==null) {
//				result = "身份证照片不能为空";
//			} else if (request.getBusinessPic()==null) {
//				result = "企业营业执照不能为空";
//			}
//
//			if (StringUtils.isNotBlank(result)) {
//				response.addErrInfo("货物企业认证", result, null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			UserInfoPo userInfoPo = this.userMapper.selectByPrimaryKey(request.getUserId());
//			if(userInfoPo==null){
//				response.addErrInfo("货物企业认证", "该用户不存在！", null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			//一个用户只能认证一次
//			CargoCompanyAuthorPo authorPo=this.cargoCompanyAuthorPoMapper.selectByUserId(request.getUserId());
//			if(authorPo!=null){
//				if(authorPo.getStatus()==0 || authorPo.getStatus()==1){
//					response.addErrInfo("货物企业认证", "货物企业认证正在认证中！", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				if(authorPo.getStatus()==2){
//					response.addErrInfo("货物企业认证", "货物企业认证已经认证", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				
//				if(authorPo.getStatus()==3){	//认证失败的，不新增记录
//					CargoCompanyAuthorPo po=authorPo;
//					po.setUserId(request.getUserId());
//					po.setCompanyName(request.getCompanyName());
//					po.setLegalPerson(request.getLegalPerson());
//					po.setBusinessNo(request.getBusinessNo());
//					po.setIdCard(request.getIdCard());
//					po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//					String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setIdCardPic(idCardUrl);
//					String bisPicUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getBusinessPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setBusinessPic(bisPicUrl);
//					this.cargoCompanyAuthorPoMapper.updateByPrimaryKey(po);
//					response.setStatus(1);
//					return response;
//				}
//			}
//			CargoCompanyAuthorPo po=new CargoCompanyAuthorPo();
//			po.setUserId(request.getUserId());
//			po.setCompanyName(request.getCompanyName());
//			po.setLegalPerson(request.getLegalPerson());
//			po.setBusinessNo(request.getBusinessNo());
//			po.setIdCard(request.getIdCard());
//			po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//			String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//			po.setIdCardPic(idCardUrl);
//			String bisPicUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getBusinessPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//			po.setBusinessPic(bisPicUrl);
//			this.cargoCompanyAuthorPoMapper.insert(po);
//			response.setStatus(1);
//			return response;
//		} catch (Exception e) {
//			OpenApiBaseException excp = new OpenApiBaseException(e);
//			throw excp;
//		}
//	}
//	
//	/**
//	 * 货主个人认证
//	 */
//	public AuthorResponse addCargoAuthor(CargoAuthorRequest request) throws OpenApiBaseException {
//		AuthorResponse response = new AuthorResponse();
//		String result = null;
//		try {
//			// ①参数验证
//			if (request.getUserId()==null) {
//				result = "申请人不能为空";
//			} else if (StringUtils.isBlank(request.getAuthorName())) {
//				result = "认证姓名不能为空";
//			} else if (StringUtils.isBlank(request.getIdCard())) {
//				result = "身份证号不能为空";
//			} else if (request.getIdCardPic()==null) {
//				result = "身份证照片不能为空";
//			} 
//
//			if (StringUtils.isNotBlank(result)) {
//				response.addErrInfo("货主个人认证", result, null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			UserInfoPo userInfoPo = this.userMapper.selectByPrimaryKey(request.getUserId());
//			if(userInfoPo==null){
//				response.addErrInfo("货主个人认证", "该用户不存在！", null);
//				response.setSuccessCount(0);
//				return response;
//			}
//			//一个用户只能认证一次
//			CargoAuthorPo authorPo=this.cargoAuthorPoMapper.selectByUserId(request.getUserId());
//			if(authorPo!=null){
//				if(authorPo.getStatus()==0 || authorPo.getStatus()==1){
//					response.addErrInfo("货主个人认证", "货主个人认证正在认证中！", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				if(authorPo.getStatus()==2){
//					response.addErrInfo("货主个人认证", "货主个人认证已经认证", null);
//					response.setSuccessCount(0);
//					return response;
//				}
//				if(authorPo.getStatus()==3){	//认证失败的，不新增记录
//					CargoAuthorPo po=authorPo;
//					po.setUserId(request.getUserId());
//					po.setAuthorName(request.getAuthorName());
//					po.setIdCard(request.getIdCard());
//					po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//					String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//					po.setIdCardPic(idCardUrl);
//					this.cargoAuthorPoMapper.updateByPrimaryKey(po);
//					response.setStatus(1);
//					return response;
//				}
//			}
//			//插入参数进行更新
//			CargoAuthorPo po=new CargoAuthorPo();
//			po.setUserId(request.getUserId());
//			po.setAuthorName(request.getAuthorName());
//			po.setIdCard(request.getIdCard());
//			po.setStatus(1);	//'状态（0=未认证、1=认证中、2=已认证、3=认证失败）'
//			String idCardUrl = FileUtil.uploadFile(request.getUserId().toString(), request.getIdCardPic(), FILE_CONSTANT.FILE_SOURCE_AUTHOR_SET, messageSource);
//			po.setIdCardPic(idCardUrl);
//			this.cargoAuthorPoMapper.insert(po);
//			response.setStatus(1);
//			return response;
//		} catch (Exception e) {
//			OpenApiBaseException excp = new OpenApiBaseException(e);
//			throw excp;
//		}
//	}
//	
//}
