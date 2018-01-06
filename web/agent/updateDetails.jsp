<%-- 
    Document   : updateDetails
    Created on : 06-Dec-2017, 17:27:55
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">






<!DOCTYPE html>
<html>
   <div class="container">
    <h1>Edit Profile</h1>
  	<hr>
	<div class="row">
      <!-- left column -->
      
<form action="../UploadAgentImageServlet" method="post" enctype="multipart/form-data">
      <div class="col-md-3">
        <div class="text-center">
          <img src="/LitRealty/agent/agentImages/${currentAgent.getImage()}" class="avatar img-circle" alt="avatar">
          <h6>Upload a different photo...</h6>
          
          <input type="file" class="form-control" name="agentimage"><br><br>
          <input type="submit" value="Update Image"/>
        </div>
      </div>
</form
      
      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        <div class="alert alert-info alert-dismissable">
          <a class="panel-close close" data-dismiss="alert">×</a> 
          <i class="fa fa-coffee"></i>
          View or Update Your Details Below
        </div>
        <h3>Personal info</h3>
        
        <form class="form-horizontal" role="form" action="../UpdateAgentDetailsServlet">
          <div class="form-group">
            <label class="col-lg-3 control-label">Name:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="name" value=${currentAgent.getName()}>
            </div>
          </div>
            
          <div class="form-group">
            <label class="col-lg-3 control-label">Phone Number:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="phonenumber" value=${currentAgent.getPhone()}>
            </div>
          </div>
            
          <div class="form-group">
            <label class="col-lg-3 control-label">Fax Number:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="fax" value=${currentAgent.getFax()}>
            </div>
          </div>
            
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="email" value=${currentAgent.getEmail()}>
            </div>
          </div>
            
            
            
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <input type="submit" class="btn btn-primary" value="Save Changes">
              <span></span>
              <input type="reset" class="btn btn-default" value="Cancel">
            </div>
          </div>
            
        </form>
      </div>
  </div>
</div>
<hr>
</html>
