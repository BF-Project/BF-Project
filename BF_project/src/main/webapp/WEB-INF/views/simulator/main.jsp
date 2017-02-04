<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<style>
/*시뮬레이터 CSS*/
 	.layer {display:none; position:fixed; _position:absolute; top:0; left:0; width:100%; height:100%; z-index:100;}
		.layer .bg {position:absolute; top:0; left:0; width:100%; height:100%; background:#000; opacity:.5; filter:alpha(opacity=50);}
		.layer .pop-layer {display:block;}

	.pop-layer {display:none; position: absolute; top: 130px; left: 300px; width: 400px; height:600px;  background-color:#fff; border: 5px solid #3571B5; z-index: 10;}	
	.pop-layer .pop-container {padding: 20px 25px;}
	.pop-layer p.ctxt {color: #666; line-height: 25px;}
	.pop-layer .btn-r {width: 100%; margin:10px 0 20px; padding-top: 10px; border-top: 1px solid #DDD; text-align:right;}

	a.cbtn {display:inline-block; height:25px; padding:0 14px 0; border:1px solid #304a8a; background-color:#3f5a9d; font-size:13px; color:#fff; line-height:25px;}	
	a.cbtn:hover {border: 1px solid #091940; background-color:#1f326a; color:#fff;}


/* input[type="checkbox"] {
    display:none;
}

input[type="checkbox"] + label {
    color:#f2f2f2;
}

input[type="checkbox"] + label span {
    display:inline-block;
    width:19px;
    height:19px;
    margin:-2px 10px 0 0;
    vertical-align:middle;
    background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) left top no-repeat;
    cursor:pointer;
}

input[type="checkbox"]:checked + label span {
    background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) -19px top no-repeat;
} */

input[type="radio"] {
    display:none;
}

input[type="radio"] + label {
    color:#f2f2f2;
    font-family:Arial, sans-serif;
}

input[type="radio"] + label span {
    display:inline-block;
    width:19px;
    height:19px;
    margin:-2px 10px 0 0;
    vertical-align:middle;
    background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) -38px top no-repeat;
    cursor:pointer;
}

input[type="radio"]:checked + label span {
    background:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/check_radio_sheet.png) -57px top no-repeat;
}


select { width: 70px; /* 원하는 너비설정 */ 
	padding: .3em .2em; /* 여백으로 높이 설정 */ 
	font-family: inherit; /* 폰트 상속 */ 
	background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%; /* 네이티브 화살표 대체 */ 
	border: 1px solid #999; border-radius: 0px; /* iOS 둥근모서리 제거 */ 
	-webkit-appearance: none; /* 네이티브 외형 감추기 */ 
	-moz-appearance: none; 
	appearance: none; 
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: center;
    padding: 8px;
}



</style>
</head>
<body>
	<%-- <script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"></script> --%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/examples-base.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/highlight.min.js"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=B3S2a2PwxQRRyezwDNUx&amp;submodules=panorama"></script>
    
  <script>
        var HOME_PATH = '<%=request.getContextPath()%>/resources';
  </script>
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
    url: HOME_PATH +'/data/jeju.geojson',
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
        //e.feature.getProperty('EMD_KOR_NM');
        document.getElementById('address').value=e.feature.getProperty('EMD_KOR_NM');
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
	
	$('#offOption').hide();

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
		document.frm.reset();
	});

	/* $('.layer .bg').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
		$('.layer').fadeOut();
		e.preventDefault();
	}); */

}

function start(form){
	if($('#addrDetail').val()==''){
		alert('상세주소를 입력해 주세요');
		return;
	}
	$.ajax({
		url:"start",
		type:"post",
		data:{"radio":$('input:radio[name="radio"]:checked').val(),
			"addr":$('#address').val(),
			"sel":$("select[name=sel]").val(),
			"addrDetail":$('#addrDetail').val()
		},
		success:function(data){
			
		}
	});
}

function changeOption1(){
	$('#offOption').hide();
}

function changeOption2(){
	$('#offOption').show();
}

</script>
</div>
<div class="layer">
	<div class="bg"></div>
	<div id="layer2" class="pop-layer">
		<div class="pop-container">
			<div class="pop-conts">
				<!--content //-->
					<form name="frm">
		<table styleborder:1px>
			<tr>
				<td>읍면동 :</td>
				<td><input type="text" id="address" value=""></td>
				<!-- <td><input type="button" value="주소검색" onclick="test();" class="btn-r"></td> -->
			</tr>
			<tr>
				<td>상세주소 : </td>
				<td><input type="text" id="addrDetail"></td>
			</tr>
			<tr>
				<td>보유자산 :</td>
				<td colspan="2"><input type="text" id="asset"></td>
			</tr>

			<tr>
				<td>창업종류 : </td>
				<td colspan="2">
						<input type="radio" name="radio" id="radio1" class="radio" value="온라인 창업" checked onclick="changeOption1();"><label for="radio1" style="color:black;"><span></span>온라인 창업</label>
						<input type="radio" name="radio" id="radio2" class="radio" value="오프라인 창업" onclick="changeOption2();"><label for="radio2" style="color:black;"><span></span>오프라인 창업</label>
				
				</td>
			</tr>
			<tr style="text-align:center;" id="offOption">
				<td colspan="3"><select style="width: 200px;">
						<option value="#">선택하세요</option>
						<option value="chicken">치킨/호프</option>
						<option value="cafe">까페</option>
						<option value="restaurant">요식업</option>
						<option value="pension">숙박/펜션</option>
				</select></td>
			</tr>
			<tr>
				<td>영업시간 : </td>
				<td>&nbsp;&nbsp;
				<%
					String open = "";
					List<String> openResult = new ArrayList<String>();
					for(int i=0;i<24;i++){
						int j=i+1;
						open = j+"";
						openResult.add(i, open);
					}
				%>
				<select name="sel">
					<c:forEach items="<%=openResult%>" var="item" begin="0" end="23">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>시간
			</tr>
			<tr style="height:70px;"></tr>
			<tr>
				<td colspan="3"><input type="button" value="start" onclick="start(this.form);"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="reset"/></td>
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

<script>
	
</script>

</body>

