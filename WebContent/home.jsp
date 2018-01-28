
<!DOCTYPE html>
<html lang="en" class="app">
<head>  
  <meta charset="utf-8" />
  <title>Home</title>
  <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="js/jPlayer/jplayer.flat.css" type="text/css" />
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="css/animate.css" type="text/css" />
  <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="css/font.css" type="text/css" />
  <link rel="stylesheet" href="css/app.css" type="text/css" />
  <link rel="stylesheet" href="css/style_card.css" type="text/css" />  
</head>
<body class="">
  <section class="vbox">
    <header class="bg-white-only header header-md navbar navbar-fixed-top-xs">
      <div class="navbar-header aside bg-info nav-xs">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
          <i class="icon-list"></i>
        </a>
        <a href="Home.html" class="navbar-brand text-lt">
          <i class="icon-film"></i>
          <img src="images/logo.png" alt="." class="hide">
          <span class="hidden-nav-xs m-l-sm" style="font-family: 'CollegeMovie'; font-size: 30px; font-weight: normal;">MyAgenda</span>
        </a>
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".user">
          <i class="icon-settings"></i>
        </a>
      </div>      <ul class="nav navbar-nav hidden-xs">
        <li>
          <a href="#nav,.navbar-header" data-toggle="class:nav-xs,nav-xs" class="text-muted">
            <i class="fa fa-indent text"></i>
            <i class="fa fa-dedent text-active"></i>
          </a>
        </li>
      </ul>
      <form class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs">
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-btn">
              <button type="submit" onclick="SearchEvent();return false;" class="btn btn-sm bg-white btn-icon rounded"><i class="fa fa-search"></i></button>
            </span>
            <input type="text" id="search_keywords" class="form-control input-sm no-border rounded" placeholder="Chercher un contact ...">
          </div>
        </div>
      </form>
      
    </header>
    <section>
      <section class="hbox stretch">
        <!-- .aside -->
        <aside class="bg-black dk nav-xs aside hidden-print" id="nav">          
          <section class="vbox">
            <section class="w-f-md scrollable">
              <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="10px" data-railOpacity="0.2">
                


                <!-- nav -->                 
                <nav class="nav-primary hidden-xs">
                  <ul class="nav bg clearfix">
                   <br>
                    <li>
                      <a href="displayGroup.jsp">
                        <i class="icon-users icon text-success"></i>
                        <span class="font-bold">Mes groupes</span>
                      </a>
                    </li>
                     <li>
                      <a href="deleteGroup.jsp">
                        <i class="icon-close icon text-success"></i>
                        <span class="font-bold">Supprimer groupe</span>
                      </a>
                    </li>
                    <li>
                      <a href="displayContacts.jsp">
                        <i class="icon-emoticon-smile  text-info"></i>
                        <span class="font-bold">Mes contacts</span>
                      </a>
                    </li>
                    
                    <li>
                      <a href="deleteContacts.jsp">
                        <i class="icon-close icon  text-info"></i>
                        <span class="font-bold">Supprimer contact</span>
                      </a>
                    </li>
                    
                    <li>
                      <a action ="peupler">
                        <i class=" icon-magic-wand text-warning"></i>
                        <span class="font-bold">Peupler ma BD </span>
                      </a>
                    </li>
                    <li class="m-b hidden-nav-xs"></li>
                  </ul>

                </nav>
                <!-- / nav -->
              </div>
            </section>
            
  
          </section>
        </aside>
        <!-- /.aside -->
        <section id="content">
          <section class="hbox stretch">
            <section>
              <section class="vbox">
                <section class="scrollable padder-lg w-f-md" id="bjax-target" style="bottom:0px">
                  <h2 class="font-thin m-b"> Bienvenue !  <span class="musicbar animate inline m-l-sm" style="width:20px;height:20px">
                    <span class="bar1 a1 bg-primary lter"></span>
                    <span class="bar2 a2 bg-info lt"></span>
                    <span class="bar3 a3 bg-success"></span>
                    <span class="bar4 a4 bg-warning dk"></span>
                    <span class="bar5 a5 bg-danger dker"></span>
                  </span></h2>
                  <div class="row row-sm" id="MostPopularMovies">
                   
                 </div>
                  <div class="row">
                    <div class="col-md-7">
                      <h2 class="font-thin">Ajouter un nouveau Contact</h2>
                      
                      
                  <section class="panel panel-default">
                    <div class="panel-body">
                      <form class="bs-example form-horizontal">
                        <div class="form-group">
                          <label class="col-lg-2 control-label">Email</label>
                          <div class="col-lg-10">
                            <input type="email" class="form-control" placeholder="Email">
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-lg-2 control-label">Password</label>
                          <div class="col-lg-10">
                            <input type="password" class="form-control" placeholder="Password">
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <div class="col-lg-offset-2 col-lg-10" align='right'>
                            <button type="submit" class="btn btn-s-md btn-primary">Ajouter</button>
                          </div>
                        </div>
                      </form>
                    </div>
                  </section>
                </div>
              
                      
                    
                    <div class="col-md-5">
                      <h2 class="font-thin">Mes groupes </h2>
                      <div class="list-group bg-white list-group-lg no-bg auto" id="listGroups">    
                     
                     </div>
                    </div>
                  </div>

                <!-- footer -->

				  <!-- / footer -->
                </section>
              </section>
            </section>
            <!-- side content -->
           <!-- / side content -->
          </section>
         </section>
      </section>
    </section>    
  </section>
  <script src="js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="js/bootstrap.js"></script>
  <!-- App -->
  <script src="js/app.js"></script>  
  <script src="js/slimscroll/jquery.slimscroll.min.js"></script>
  <script src="js/app.plugin.js"></script>
  <script type="text/javascript" src="js/profile.js"></script>
</body>
</html>