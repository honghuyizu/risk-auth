package com.risk.api.service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.risk.api.entity.BaseUser;
import com.risk.api.model.User;
import com.risk.api.model.ZhuCeDTO;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Administrator on 2017/3/3.
 */
@Path("risk/api")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface UserService {

    /**
     * 新增user
     * @param user
     * @return
     */
    @POST
    @Path("addUser")
    public Response addUser(BaseUser user);



    @GET
    @Path("{name}/getUser")
    public Response getUser(@NotNull(message = "用户ID不能为空") @PathParam("name") String name);

}
