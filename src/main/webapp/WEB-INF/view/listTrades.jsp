<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<link href="/css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["table", "corechart"]});
      google.setOnLoadCallback(drawTableAndChart);

      function drawTableAndChart() {
    	
    	if ('${alltrades}' == '[]') {
    		return;
    	} 
    		
    	
    	// Drawing table
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'User ID');
        data.addColumn('string', 'Currency From');
        data.addColumn('string', 'Currency To');
        data.addColumn('string', 'Amount Sell');
        data.addColumn('string', 'Amount Buy');
        data.addColumn('string', 'Rate');
        data.addColumn('string', 'Date');
        data.addColumn('string', 'Country');
        data.addRows([
			<c:forEach items="${alltrades}" var="trade">
			[ '${trade.userId}', '${trade.currencyFrom}', '${trade.currencyTo}', ${trade.amountSell}.toFixed(2), ${trade.amountBuy}.toFixed(2), '${trade.rate}', '${trade.formattedDate}', '${trade.originatingCountry}' ],
			</c:forEach>                      
        ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));
        table.draw(data, {showRowNumber: true});
        
        var colors = [ "aqua", "blue", "fuchsia", "gray", "green", "lime", "maroon", "navy", "olive", "orange", "purple", "red", "silver", "teal", "yellow" ];
        
        // Drawing chart Incoming Currencies 
        var data = google.visualization.arrayToDataTable([
           ["Currency From", "Number of Trades", { role: "style" } ],
           
			<c:forEach items="${tradesByCurrencyFrom}" var="item" varStatus="status">
				[ '${item[0]}', ${item[1]}, colors[${status.index} % colors.length] ],				
			</c:forEach>  			

         ]);

         var view = new google.visualization.DataView(data);
         view.setColumns([0, 1,
                          { calc: "stringify",
                            sourceColumn: 1,
                            type: "string",
                            role: "annotation" }, 
                            2]);

         var options = {
           title: "Trades By Incoming Currency",
           width: 600,
           height: 400,
           bar: {groupWidth: "95%"},
           legend: { position: "none" }          
         };
         var chart = new google.visualization.ColumnChart(document.getElementById("chart_currency_from_div"));
         chart.draw(view, options); 
         
         // Drawing chart Incoming Currencies 
         var data = google.visualization.arrayToDataTable([
            ["Currency From", "Number of Trades", { role: "style" } ],
            
 			<c:forEach items="${tradesByCurrencyTo}" var="item" varStatus="status">
 				[ '${item[0]}', ${item[1]}, colors[colors.length - (${status.index} % colors.length)] ],				
 			</c:forEach>  			

          ]);
         
         var view = new google.visualization.DataView(data);
         view.setColumns([0, 1,
                          { calc: "stringify",
                            sourceColumn: 1,
                            type: "string",
                            role: "annotation" }, 
                            2]);

         var options = {
           title: "Trades By Outgoing Currency",
           width: 600,
           height: 400,
           bar: {groupWidth: "95%"},
           legend: { position: "none" }          
         };
         var chart = new google.visualization.ColumnChart(document.getElementById("chart_currency_to_div"));
         chart.draw(view, options);          
         
      }
    </script>
  </head>
  <body>
  	<h1>Market Trade Processor</h1>
    <div id="table_div"></div>
    <div id="chart_currency_from_div"></div>
    <div id="chart_currency_to_div"></div>
  </body>
</html>