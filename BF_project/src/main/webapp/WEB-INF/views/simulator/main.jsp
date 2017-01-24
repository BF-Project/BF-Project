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
        var myWindow = window.open("", "MsgWindow", "width=200,height=100");
        myWindow.document.write(e.feature.getProperty('EMD_KOR_NM'));
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


</script>
</div>

</body>
</html>
