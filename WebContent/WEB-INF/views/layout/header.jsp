<!-- Não necessita das definições normais de página, pois esse arquivo será inserido no baselayout, que já possui as definições 
<div style="width: 100%; text-align: center">
	<b>Aqui é o menu</b>
</div> -->

<!-- Código copiado e após editado de: https://getbootstrap.com/docs/3.3/components/#navbar -->

<nav class="navbar navbar-inverse"> <!-- Alterando para navbar-default altera as cores da barra -->
 
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">TreinaWeb Spring MVC</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Álbuns <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Listar</a></li>
            <li><a href="#">Cadastrar</a></li>
          </ul>
        </li>
      </ul>
      
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Músicas <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Listar</a></li>
            <li><a href="#">Cadastrar</a></li>
          </ul>
        </li>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  
</nav>
