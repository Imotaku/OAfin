<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 文件列表 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <a class="fa fa-refresh btn btn-default light"></a>
                                <a class="fa fa-trash btn btn-default light"></a>
                                <a class="fa fa-plus btn btn-default light" href="/uploadFile/toAdd"></a>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                            <tr class="">
                                <th class="text-center hidden-xs">Select</th>
                                <th class="hidden-xs">文件名</th>
                                <th class="hidden-xs">文件存储url</th>
                                <th class="hidden-xs">操作人</th>
                                <th class="hidden-xs">时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="emp">
                                <tr class="message-unread">
                                    <td class="hidden-xs">
                                        <label class="option block mn">
                                            <input type="checkbox" name="mobileos" value="FR">
                                            <span class="checkbox mn"></span>
                                        </label>
                                    </td>
                                    <td>${emp.fileName}</td>
                                    <td>${emp.fileUrl}</td>
                                    <td class="text-center fw600">${emp.operaterName}</td>
                                    <td class="hidden-xs">
                                        <span class="badge badge-warning mr10 fs11">${emp.gmtTime}</span>
                                    </td>
                                    <td>
                                        <a class="btn btn-primary active btn-sm" href="/uploadFile/toDownload/${emp.id}">
                                            <span class="glyphicon glyphicon-download"></span> 下载
                                        </a>
                                        <a class="btn btn-primary active btn-sm" href="/uploadFile/toUpdate/${emp.id}">
                                            <span class="glyphicon glyphicon-edit"></span> 编辑
                                        </a>
                                        <a class="btn btn-danger active btn-sm" href="/uploadFile/remove/${emp.id}">
                                            <span class="glyphicon glyphicon-trash"></span> 删除
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>