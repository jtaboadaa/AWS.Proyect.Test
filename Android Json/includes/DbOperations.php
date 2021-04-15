<?php 

	class DbOperations{

		private $con; 

		function __construct(){

			require_once dirname(__FILE__).'/DbConnect.php';

			$db = new DbConnect();

			$this->con = $db->connect();

		}

		/*CRUD -> C -> CREATE */

		public function createCoorde($fecha,$hora, $latitud, $longitud){

				$stmt = $this->con->prepare("INSERT INTO `ubicacion` (`fecha`, `hora`, `latitud`, `longitud`) VALUES (?, ?, ?, ?);");
				$stmt->bind_param($fecha,$hora,$latitud,$longitud);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			
		}


	}