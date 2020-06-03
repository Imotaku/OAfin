<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 编辑公告信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/adverstise/update/${adverstise.id}" modelAttribute="adverstise"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 公告信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="title" class="field prepend-icon">
                                    <input id="title" name="title" class="gui-input" placeholder="标题...." type="text" value="${adverstise.title}"/>
                                    <label for="title" class="field-icon">
                                        <i class="fa fa-font"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-12">
                                <label for="context" class="field prepend-icon">
                                    <input id="context" name="context" class="gui-input" placeholder="公告内容...." type="text" value="${adverstise.context}"/>
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
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>