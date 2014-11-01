

function seleccionarFila() {
    
    btnRemove.enable();
}
function deseleccionarFila() {
    
    btnRemove.disable();
}

function clearCheckboxes(widgetVar)
 {
            widgetVar.toggleCheckAll();
            
            if(widgetVar.getSelectedRowsCount() > 0)
            {
                widgetVar.toggleCheckAll();
            }
 }
        
        
        $(document).ready(function (){
            
            $("#panelEnvio\\:panelGrid:cancelBtn").click(function (){
                $("#panelEnvio").hide();
           
             });
        });

