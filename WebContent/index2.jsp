<!doctype html>
<html>
   <head>
      <title>jQueryUI Autocomplete - Default Functionality</title>
      <link href="http://code.jquery.com/ui/1.10.4/themes/south-street/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-2.1.1.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  
      <script>
         $(function() {
            var countryNames = [
               "Australia",
               "Austria",
               "Bangladesh",
               "Chile",
               "China",
               "Denmark",
               "England",
               "France",
               "Finland",
               "Greece",
               "Germany",
               "Honkong",
               "India",
               "Japan",
               "kazakhstan",
               "USA",
               "Zimbabwe"
            ];
  
            $( "#automplete" ).autocomplete({
               source: countryNames
            });
            $( "#automplete" ).autocomplete("option", "position", { my : "right-10 top+40", at: "right top" }) 
         });
      </script>
   </head>
   <body> 
      <div class="ui-widget">
         <label for="automplete">Country: </label>
         <input id="automplete">
      </div>
   </body>
</html>