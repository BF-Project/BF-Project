<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>행정구역 GeoJSON 데이터 레이어 표시하기</title>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/examples-base.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/highlight.min.js"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=B3S2a2PwxQRRyezwDNUx&amp;submodules=panorama"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/examples-base.css" />
    <script>
        var HOME_PATH = '<%=request.getContextPath()%>/resources';
    </script>

<style type="text/css">
	.layer {display:none; position:fixed; _position:absolute; top:0; left:0; width:100%; height:100%; z-index:100;}
		.layer .bg {position:absolute; top:0; left:0; width:100%; height:100%; background:#000; opacity:.5; filter:alpha(opacity=50);}
		.layer .pop-layer {display:block;}

	.pop-layer {display:none; position: absolute; top: 130px; left: 300px; width: 410px; height:700px;  background-color:#fff; border: 5px solid #3571B5; z-index: 10;}	
	.pop-layer .pop-container {padding: 20px 25px;}
	.pop-layer p.ctxt {color: #666; line-height: 25px;}
	.pop-layer .btn-r {width: 100%; margin:10px 0 20px; padding-top: 10px; border-top: 1px solid #DDD; text-align:right;}

	a.cbtn {display:inline-block; height:25px; padding:0 14px 0; border:1px solid #304a8a; background-color:#3f5a9d; font-size:13px; color:#fff; line-height:25px;}	
	a.cbtn:hover {border: 1px solid #091940; background-color:#1f326a; color:#fff;}
	
	
	
	.checks {position: relative;} 

.checks input[type="checkbox"] { /* 실제 체크박스는 화면에서 숨김 */ 
	position: absolute; 
	width: 1px; 
	height: 1px; 
	padding: 0; 
	margin: -1px; 
	overflow: hidden; 
	clip:rect(0,0,0,0); border: 0 } 

.checks input[type="checkbox"] + label {
	display: inline-block; 
	position: relative; 
	cursor: pointer; 
	-webkit-user-select: none; 
	-moz-user-select: none; 
	-ms-user-select: none; } 

.checks input[type="checkbox"] + label:before { /* 가짜 체크박스 */ 
	content: ' '; 
	display: inline-block; 
	width: 21px; /* 체크박스의 너비를 지정 */ 
	height: 21px; /* 체크박스의 높이를 지정 */ 
	line-height: 21px; /* 세로정렬을 위해 높이값과 일치 */ 
	margin: -2px 8px 0 0; 
	text-align: center; 
	vertical-align: middle; 
	background: white; 
	border: 1px solid #000000; 
	border-radius : 3px; 
	box-shadow: 0px 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05); } 

.checks input[type="checkbox"] + label:active:before, .checks input[type="checkbox"]:checked + label:active:before { 
	box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px 1px 3px rgba(0,0,0,0.1); } 

.checks input[type="checkbox"]:checked + label:before { /* 체크박스를 체크했을때 */ 
	content: '\2714'; /* 체크표시 유니코드 사용 */ 
	color: #FF0000; 
	text-shadow: 1px 1px #FF0000; 
	background: white; 
 	border-color: #000000; /* 검정 */
	box-shadow: 0px 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05), inset 15px 10px -12px rgba(255,255,255,0.1); }
</style>

</head>
<body>

<!-- @category DataLayer -->

<div id="page">

<div id="wrap" class="section">
    <br><br>
<div style="text-align:center;"><h2>SIMULATOR</h2>
(창업할 지역을 선택해주세요)</div>
<hr color="grey" width="1000px">
    <div id="map" style="width:70%;height:600px; margin:0 auto;"></div>
</div>
<script id="code">
var map = new naver.maps.Map(document.getElementById('map'), {
    zoom: 6,
    mapTypeId: 'normal',
    center: new naver.maps.LatLng(33.3718377, 126.5298401)

});

var HOME_PATH = window.HOME_PATH || '.';

$.ajax({
    url: HOME_PATH +'/data/jeju_test.geojson',
    dataType: 'json',
    success: startDataLayer
});

var tooltip = $('<div style="position:absolute;z-index:1000;padding:5px 10px;background-color:#fff;border:solid 2px #000;font-size:14px;pointer-events:none;display:none;"></div>');
tooltip.appendTo(map.getPanes().floatPane);

function startDataLayer(geojson) {
    map.data.addGeoJson(geojson);

    map.data.setStyle(function(feature) {
        var color = 'lightgreen';

        if (feature.getProperty('isColorful')) {
            color = feature.getProperty('color');
        }
 
        return {
            //fillColor: none,
            strokeColor: color,
            strokeWeight: 2,
            icon: null
        };
    });

    map.data.addListener('click', function(e) {
        e.feature.setProperty('isColorful', true);
        $('#address').value=e.feature.getProperty('EMD_KOR_NM');
        layer_open('layer2');return false;
    });

    map.data.addListener('dblclick', function(e) {
        var bounds = e.feature.getBounds();

        if (bounds) {
            map.panToBounds(bounds);
        }
    });

    map.data.addListener('mouseover', function(e) {
        map.data.overrideStyle(e.feature, {
            strokeWeight: 8,
            icon: HOME_PATH +'/images/pin_spot.png'
        });
        
        var feature = e.feature,
        regionName = feature.getProperty('EMD_KOR_NM');
        
        tooltip.css({
            display: '',
            left: e.offset.x,
            top: e.offset.y
        }).text(regionName);
        
    });

    map.data.addListener('mouseout', function(e) {
    	tooltip.hide().empty();
        map.data.revertStyle();
    });
}


function layer_open(el){

	var temp = $('#' + el);
	var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수

	if(bg){
		$('.layer').fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
	}else{
		temp.fadeIn();
	}

	/* // 화면의 중앙에 레이어를 띄운다.
	if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
	else temp.css('top', '0px');
	if (temp.outerWidth() < $(document).width() ) temp.css('margin-right', '-'+temp.outerWidth()/10+'px');
	else temp.css('right', '0px'); */

	temp.find('a.cbtn').click(function(e){
		if(bg){
			$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
		}else{
			temp.fadeOut();
		}
		e.preventDefault();
	});

	/* $('.layer .bg').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
		$('.layer').fadeOut();
		e.preventDefault();
	}); */

}				

</script>
</div>
<div class="layer">
	<div class="bg"></div>
	<div id="layer2" class="pop-layer">
		<div class="pop-container">
			<div class="pop-conts">
				<!--content //-->
					<form>
		<table>
			<tr>
				<td>상세주소 :</td>
				<td><input type="text" id="address"></td>
				<td><input type="button" value="주소검색" onclick="test();" class="btn-r">
				</td>
			</tr>
			<tr>
				<td>보유자산 :</td>
				<td colspan="2"><input type="text" id="asset"></td>
			</tr>

			<tr>
				<td>창업종류</td>
				<td colspan="2"><input type="checkbox" name="checks" value="온라인 창업">온라인
					창업&nbsp; <input type="checkbox" name="checks" value="오프라인 창업">오프라인
					창업</td>
			</tr>
			<tr>
				<td colspan="3"><select style="width: 200px;">
						<option value="#">선택하세요</option>
						<option value="chicken">치킨/호프</option>
						<option value="cafe">까페</option>
						<option value="restaurant">요식업</option>
						<option value="pension">숙박/펜션</option>
				</select></td>
			</tr>
			<tr>
				<td>영업기간</td>
				<td><select>
						<option value="1">1월</option>
						<option value="2">2월</option>
						<option value="3">3월</option>
				</select> ~ <select>
						<option value="1">1월</option>
						<option value="2">2월</option>
						<option value="3">3월</option>
				</select></td>
			</tr>
		</table>
	</form>

				<div class="btn-r">
					<a href="#" class="cbtn">Close</a>
				</div>
				<!--// content-->
			</div>
		</div>
	</div>
</div>

<form>
	<input type="radio" name="test">라디오1
	<input type="radio" name="test">라디오2
	<input type="checkbox" name="test1">체크박스1
	<input type="checkbox" name="test1">체크박스2
</form>

</body>
</html>
