<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 编辑文件信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/uploadFile/update/${uploadFile.id}" modelAttribute="uploadFile"  id="admin-form" name="addForm" enctype="multipart/form-data">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 文件信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="fileName" class="field prepend-icon">
                                    <input id="fileName" name="fileName" class="gui-input" placeholder="文件名" type="text" value="${uploadFile.fileName}"/>
                                    <label for="fileName" class="field-icon">
                                        <i class="fa fa-font"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6" style="display: none;">
                                <label for="fileUrl" class="field prepend-icon">
                                    <input id="fileUrl" name="fileUrl" class="gui-input" placeholder="文件url" type="text" value="${uploadFile.fileUrl}"/>
                                    <label for="fileUrl" class="field-icon">
                                        <i class="fa fa-file"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-12">
                                <label for="file" class="field prepend-icon">
                                    <input id="file" name="file" class="gui-file" placeholder="文件...." type="file"/>
                                    <label for="file" class="field-icon">
                                        <i class="fa fa-file"></i>
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