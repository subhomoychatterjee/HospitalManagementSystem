<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Patient Invoice</title>
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- themify icons CSS -->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Animations CSS -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Main CSS -->
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="css/red.css" id="style_theme">
	<link rel="stylesheet" href="css/responsive.css">

	<script src="js/modernizr.min.js"></script>
</head>

<body>
	<!-- Pre Loader -->
	<div class="loading">
		<div class="spinner">
			<div class="double-bounce1"></div>
			<div class="double-bounce2"></div>
		</div>
	</div>
	<!--/Pre Loader -->
	<!-- Color Changer -->
	
	<!-- /Color Changer -->
	<div class="wrapper">
		<!-- Sidebar -->
		<nav id="sidebar" class="proclinic-bg">
			<div class="sidebar-header">
				<!-- <a href="#"><img src="" class="logo" alt="logo"></a> -->
			</div>
			<ul class="list-unstyled components">
				<li>
					<a href="index.jsp">
						<span class="ti-layout-menu-v"></span> Dashboard
					</a>
				</li>
				<li>
						<a href="#nav-patients" data-toggle="collapse" aria-expanded="false">
							<span class="ti-wheelchair"></span> Patients
						</a>
						<ul class="collapse list-unstyled" id="nav-patients">
							<li>
								<a href="PatientRegistration.jsp">Add Patient</a>
							</li>
							<li>
								<a href="ViewPatients.jsp">All Patients</a>
							</li>
							<li>
								<a href="Search.jsp">Patient Details</a>
							</li>
							<li>
								<a href="PatientUpdate.jsp">Edit Patient</a>
							</li>
							<li>
								<a href="PatientDelete.jsp">Delete Patient</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#nav-doctors" data-toggle="collapse" aria-expanded="false">
							<span class="ti-user"></span> Pharmacy
						</a>
						<ul class="collapse list-unstyled" id="nav-doctors">
							<li>
								<a href="MedsIssued.jsp">Medicines Issued</a>
							</li>
							<li>
								<a href="MedsToBeIssued.jsp">Medicines to be Issued</a>
							</li>
							
						</ul>
					</li>
					<li>
						<a href="#nav-diagnostics" data-toggle="collapse" aria-expanded="false">
							<span class="ti-pencil-alt"></span> Diagnostics
						</a>
						<ul class="collapse list-unstyled" id="nav-diagnostics">
							<li>
								<a href="TestsConducted.jsp">Tests Conducted</a>
							</li>
							<li>
								<a href="TestsToBeConducted.jsp">Tests to be Conducted</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#nav-invoice" data-toggle="collapse" aria-expanded="false">
							<span class="ti-pencil-alt"></span> Invoice
						</a>
						<ul class="collapse list-unstyled" id="nav-invoice">
							<li>
								<a href="PatientInvoice.jsp">Patient</a>
							</li>
							<li>
								<a href="PharmacyInvoice.jsp">Pharmacy</a>
							</li>
							<li>
								<a href="DiagonosticInvoice.jsp">Diagnostics</a>
							</li>
							<li>
								<a href="FinalBill.jsp">Final Bill</a>
							</li>
						</ul>
					</li>
					
			</ul>
			<div class="nav-help animated fadeIn">
				<h5><span class="ti-comments"></span> Need Help</h5>
				<h6>
					<span class="ti-mobile"></span> +1 1234 567 890</h6>
				<h6>
					<span class="ti-email"></span> email@site.com</h6>
				<p class="copyright-text">Copy rights &copy; 2018</p>
			</div>
		</nav>
		<!-- /Sidebar -->
		<!-- Page Content -->
		<div id="content">
			<!-- Top Navigation -->
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="responsive-logo">
						<!-- <a href="index-2.html"><img src="images/logo-dark.png" class="logo" alt="logo"></a> -->
					</div>
					<ul class="nav">
						<li class="nav-item">
							<span class="ti-menu" id="sidebarCollapse"></span>
						</li>
						<li class="nav-item">
							<span title="Fullscreen" class="ti-fullscreen fullscreen"></span>
						</li>
						<li class="nav-item">
							<a  data-toggle="modal" data-target=".proclinic-modal-lg">
								<span class="ti-search"></span>
							</a>
							<div class="modal fade proclinic-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
								<div class="modal-dialog modal-lorvens">
									<div class="modal-content proclinic-box-shadow2">
										<div class="modal-header">
											<h5 class="modal-title">Search Patient/Doctor:</h5>
											<span class="ti-close" data-dismiss="modal" aria-label="Close">
											</span>
										</div>
										<div class="modal-body">
											<form>
												<div class="form-group">
													<input type="text" class="form-control" id="search-term" placeholder="Type text here">
													<button type="button" class="btn btn-lorvens proclinic-bg">
														<span class="ti-location-arrow"></span> Search</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li class="nav-item">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
								<span class="ti-announcement"></span>
							</a>
							<div class="dropdown-menu proclinic-box-shadow2 notifications animated flipInY">
								<h5>Notifications</h5>
								<a class="dropdown-item" href="#">
									<span class="ti-wheelchair"></span>New Patient Added</a>
								<a class="dropdown-item" href="#">
									<span class="ti-money"></span>Patient payment done</a>
								<a class="dropdown-item" href="#">
									<span class="ti-time"></span>Patient Appointment booked</a>
								<a class="dropdown-item" href="#">
									<span class="ti-wheelchair"></span>New Patient Added</a>
							</div>
						</li>
						<li class="nav-item">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
								<span class="ti-user"></span>
							</a>
							<div class="dropdown-menu proclinic-box-shadow2 profile animated flipInY">
								<% 
		    		String username= (String) session.getAttribute("username");
		    		if(username!=null)
		    		{ %>
		    		<h5><%= username %></h5>
								<a class="dropdown-item" href="#">
									<span class="ti-settings"></span> Settings</a>
								<a class="dropdown-item" href="#">
									<span class="ti-help-alt"></span> Help</a>
								<a class="dropdown-item" href="Logout.jsp">
									<span class="ti-power-off"></span> Logout</a><% }
									else{ %>
									
								<a class="dropdown-item" href="Login.jsp">
									<span class="ti-power-off"></span> Login</a><% } %>
							</div>
						</li>
					</ul>
				
				</div>
			</nav>
			<!-- /Top Navigation -->
			<!-- Breadcrumb -->
			<div class="row no-margin-padding">
				<div class="col-md-6">
					<h3 class="block-title">Invoice</h3>
				</div>
				<div class="col-md-6">
					<ol class="breadcrumb">
						<li class="breadcrumb-item">
							<a href="index.jsp">
								<span class="ti-home"></span>
							</a>
						</li>
						<li class="breadcrumb-item">Other Pages</li>
						<li class="breadcrumb-item active">Blank Page</li>
					</ol>
				</div>
			</div>
			
			<!-- /Breadcrumb -->
			<!-- Main Content -->
			<div class="container-fluid">				
				<!-- Main Content -->
				<div class="row">
					<div class="col-md-12">
						<div class="widget-area-2 proclinic-box-shadow min-h200">
							<h3 class="widget-title">Patient Invoice</h3>
                            <form action="PatientInvoice" method="get">
							<table>
								<tr>
									<td><label for = "ssnid"><b>Patient ID: </b></label></td>
    								<td><input type = "text" name = "patient_id" pattern="[1-9]{1}[0-9]{8}" id = "patient_id" required></td>
    								<td><input type="submit" class="btn btn-primary" value="Search"></td>
    							</tr>
    						</table>

							<div class="col-md-12">
								<div class="widget-area-2 proclinic-box-shadow">
									<h3 class="widget-title">Patient Details</h3>
									<p class="margin-l20">
										
									<div class="table-div">
										<div class="table-responsive">
											<table class="table">
												<thead>
													<tr>
														<th scope="col">Patient Id</th>
														<th scope="col">Name</th>
														<th scope="col">Age</th>
														<th scope="col">Address</th>
														<th scope="col">Date of Admission</th>
														<th scope="col">Date of Discharge</th>
														<th scope="col">Type of Room</th>
														<th scope="col">Rate</th>
														
												</thead>
												<tbody>
													<tr>
														<td><% if(request.getAttribute("id")!=null) %><%= request.getAttribute("id") %></td>
														<td><% if(request.getAttribute("name")!=null) %><%= request.getAttribute("name") %></td>
														<td><% if(request.getAttribute("age")!=null) %><%= request.getAttribute("age") %></td>
														<td><% if(request.getAttribute("address")!=null) %><%= request.getAttribute("address") %></td>
														<td><% if(request.getAttribute("doj")!=null) %><%= request.getAttribute("doj") %></td>
														<td><% if(request.getAttribute("dod")!=null) %><%= request.getAttribute("dod") %></td>
														<td><% if(request.getAttribute("room_type")!=null) %><%= request.getAttribute("room_type") %></td>
														<td><% if(request.getAttribute("rate")!=null) %><%= request.getAttribute("rate") %></td>
														
													</tr>													
												</tbody>
											</table>
										</div>
									</div>
						
								</div>
							</div>

							<br>
							
							<table>
								<tr>
									<td><label for = "tda"><b>Total Days Admitted: </b></label></td>
    								<td><label id = "tda"><% if(request.getAttribute("nod")!=null) %><%= request.getAttribute("nod") %></label></td>
    							</tr>
      								
      							<tr>
   									<td><label for = "amt"><b>Amount: </b></label></td>
    								<td><label id = "amt"><% if(request.getAttribute("amount")!=null) %><%= request.getAttribute("amount") %></label></td>
      							</tr>
      						</table>
                          </form>
						</div>
					</div>
				</div>
				
			</div>
			<!-- /Main Content -->
		</div>
		<!-- /Page Content -->
	</div>
	<!-- Back to Top -->
	<a id="back-to-top" href="#" class="back-to-top">
			<span class="ti-angle-up"></span>
	</a>
	<!-- /Back to Top -->
	<!-- Jquery Library-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<!-- Popper Library-->
	<script src="js/popper.min.js"></script>
	<!-- Bootstrap Library-->
	<script src="js/bootstrap.min.js"></script>
	<!-- Custom Script-->
	<script src="js/custom.js"></script>
</body>


</html>
