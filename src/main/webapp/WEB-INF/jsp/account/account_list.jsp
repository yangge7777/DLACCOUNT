<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount(id) {
                var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
                if(r){
                  setState('3',id);
                }else {
                }
            }
            //开通  暂停 删除
            function setState(status,id) {
                window.location.href="accountStatus"+ status +".do?id="+id
            }

        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <li><a href="../index.html" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
                <li><a href="<%= request.getContextPath()%>/account/accountlist.do" class="account_on"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="<%= request.getContextPath()%>/account/accountSearch.do" method="post" >
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text"  name="idcard_no" value="${searchAccount.idcard_no==null?'不验证':searchAccount.idcard_no}" class="text_search" /></div>
                    <div>姓名：<input type="text" name="real_name" class="width70 text_search" value="${searchAccount.real_name==null?'不验证':searchAccount.real_name}" /></div>
                    <div>登录名：<input type="text" name="login_name" value="${searchAccount.login_name==null?'不验证':searchAccount.login_name}" class="text_search" /></div>
                    <div>
                        状态：
                        <select class="select_search">
                            <option value="status" selected="selected">全部</option>
                            <option value="1">开通</option>
                            <option value="2">暂停</option>
                            <option value="3">删除</option>
                        </select>
                    </div>
                    <input type="hidden" name="status" value="" id="status">
                    <div><input type="button" value="搜索" class="btn_search" onclick="push()" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='account_add.html';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                        
                        <th class="width200"></th>
                    </tr>
                        <c:forEach  var="account" items="${accountAll}">
                            <tr>
                                <td>${account.id}</td>
                                <td><a href="<%= request.getContextPath()%>/account/toaccount_detail.do?method=${account.id}">${account.real_name}</a></td>
                                <td>${account.idcard_no}</td>
                                <td>${account.login_name}</td>
                                <c:if test="${account.status==1}">
                                    <td>开通</td>
                                </c:if>
                                <c:if test="${account.status==2}">
                                    <td>暂停</td>
                                </c:if>
                                <c:if test="${account.status==3}">
                                    <td>删除</td>
                                </c:if>
                                <td>${account.create_date}</td>
                                <td>${account.last_login_time}</td>
                                <c:if test="${account.status==1}">
                                    <td class="td_modi">
                                        <input type="button" value="暂停" class="btn_pause" onclick="setState('2','${account.id}');" />
                                        <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
                                        <input type="button" value="删除" class="btn_delete" onclick="deleteAccount('${account.id}');" />
                                    </td>
                                </c:if>
                                <c:if test="${account.status==2}">
                                    <td class="td_modi">
                                        <input type="button" value="开通  " class="btn_pause" onclick="setState('1','${account.id}');" />
                                        <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
                                        <input type="button" value="删除" class="btn_delete" onclick="deleteAccount('${account.id}');" />
                                    </td>
                                </c:if>
                                <c:if test="${account.status==3}">
                                    <td class="td_modi">

                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>

                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)云科技有限公司 </p>
        </div>
    <script type="text/javascript" language="JavaScript">

        //提交表单
        function push() {
            var status="";
          status=  $(".select_search").val()
            $("#status").val(status)
            $("form").submit()
        }
    </script>
    </body>
</html>
