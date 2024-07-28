/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Chart, barChart, pieChart */

function addThonTinThem() {
    data1 = $('#infor1').val();
    data2 = $('#infor').val();
    $('#infor').val(data2 + data1 + ';');
}

function removeOptions()
{
    selectbox = $('#infor1').get(0);
    var i;
    for (i = 1; i < selectbox.options.length; i++)
    {
        if (selectbox.options[i].selected) {
            console.log(selectbox.options[i]);
            selectbox.remove(i);
        }        
    }
    selectbox.selectedIndex = 0;
}
