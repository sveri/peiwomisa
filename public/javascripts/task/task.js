require(["dojo/store/JsonRest", "dojo/data/ObjectStore", 'dojox/grid/DataGrid', 
         'dojo/date/stamp', 'dojo/date/locale', "dojo/dom", "dojo/domReady!"], 
	function(JsonRest, DataGrid, ObjectStore, dom, stamp, locale) {
	
	function formatDate(datum){
        /*Format the value in store, so as to be displayed.*/
        var d = stamp.fromISOString(datum);
        return locale.format(d, {selector: 'date', formatLength: 'long'});
    }

    function getDateValue(){
        /*Override the default getValue function for dojox.grid.cells.DateTextBox*/
        return stamp.toISOString(this.widget.get('value'));
    }
	        
    taskStore = new dojo.store.JsonRest({target:"/tasks/rest/"});
    
    grid = new dojox.grid.DataGrid({
        store: dataStore = dojo.data.ObjectStore({objectStore: taskStore}),
        structure: [
		      {'name': '', 'field': 'done', 'width': '20px',
		    	  cellType: dojox.grid.cells.Bool, editable:true },
		    	   //type: dojox.grid.cells.Bool, styles: 'text-align: center;'},
		      {'name': 'Name', 'field': 'name', 'width': '100px', editable:true },
 		      {'name': 'Due To', 'field': 'dueTo', 'width': '150px'},
 		      {'name': 'Created At', 'field': 'createdAt', 'width': '100px',
 		            formatter: formatDate,    /*Custom format, change the format in store. */
 		            editable: true,        /*Editable cell*/
 		            type: dojox.grid.cells.DateTextBox, /*Use DateTextBox in editing mode*/
 		            getValue: getDateValue,    /*Translate the value of DateTextBox to something the store can understand.*/
 		            constraint: {formatLength: 'long'} /*Format the date value shown in DateTextBox*/}
        ]
    }, "taskGridDiv"); // make sure you have a target HTML element with this id
    grid.startup();
});