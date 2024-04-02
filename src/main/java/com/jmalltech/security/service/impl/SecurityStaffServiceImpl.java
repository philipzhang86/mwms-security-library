package com.jmalltech.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jmalltech.security.entity.Staff;
import com.jmalltech.security.mapper.SecurityStaffMapper;
import com.jmalltech.security.service.SecurityStaffService;
import org.springframework.stereotype.Service;

/**
* @author philipzhang
* @description 针对表【mwms_staff】的数据库操作Service实现
* @createDate 2024-03-26 14:02:05
*/
@Service
public class SecurityStaffServiceImpl extends ServiceImpl<SecurityStaffMapper, Staff> implements SecurityStaffService {
}




