/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    for( i=0; i<0; i++) {
        jQuery('<div/>', {
            class: 'foo',
            id: 'foo' + i+1,
            href: 'http://google.com',
            title: 'Become a Googler',
            rel: 'external',
            text: 'Go to Google!'
        }).appendTo('.comment');
    }
    /*$('.comment-inside')
        .clone()
        .appendTo($('.comment'));
    }*/
    //$(".comment").append("<div class='foo'>hello world</div>");
});