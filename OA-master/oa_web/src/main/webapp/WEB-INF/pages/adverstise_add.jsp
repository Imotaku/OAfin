<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 发布公告 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form id="admin-form" name="addForm" action="/adverstise/add" method="post">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 添加公告 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="title" class="field prepend-icon">
                                    <input id="title" name="title" class="gui-input" placeholder="标题...." type="text"/>
                                    <label for="title" class="field-icon">
                                        <i class="fa fa-font"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-12">
                                <label for="context" class="field prepend-icon">
                                    <input id="context" name="context" class="gui-input" placeholder="公告内容...." type="text"/>
                                    <label for="context" class="field-icon">
                                        <i class="fa fa-font"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>