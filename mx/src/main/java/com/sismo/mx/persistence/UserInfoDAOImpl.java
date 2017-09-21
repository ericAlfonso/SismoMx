package com.sismo.mx.persistence;

import org.springframework.stereotype.Repository;

import com.sismo.mx.persistence.entities.UserInfo;

@Repository
public class UserInfoDAOImpl extends AbstractDAO<UserInfo> implements UserInfoDAO{

}
