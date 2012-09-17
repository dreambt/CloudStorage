/*!
 * Thumbnail helper for fancyBox
 * version: 1.0.6
 * @requires fancyBox v2.0 or later
 *
 * Usage:
 *     $(".fancybox").fancybox({
 *         helpers : {
 *             thumbs: {
 *                 width  : 50,
 *                 height : 50
 *             }
 *         }
 *     });
 *
 * Options:
 *     width - thumbnail width
 *     height - thumbnail height
 *     source - function to obtain the URL of the thumbnail image
 *     position - 'top' or 'bottom'
 *
 */
(function(c){var d=c.fancybox;d.helpers.thumbs={wrap:null,list:null,width:0,source:function(a){var b;if(a.element){b=c(a.element).find("img").attr("src")}if(!b&&a.type==="image"&&a.href){b=a.href}return b},init:function(o,p){var a=this,m,k=o.width||50,l=o.height||50,b=o.source||this.source;m="";for(var n=0;n<p.group.length;n++){m+='<li><a style="width:'+k+"px;height:"+l+'px;" href="javascript:jQuery.fancybox.jumpto('+n+');"></a></li>'}this.wrap=c('<div id="fancybox-thumbs"></div>').addClass(o.position||"bottom").appendTo("body");this.list=c("<ul>"+m+"</ul>").appendTo(this.wrap);c.each(p.group,function(e){var f=b(p.group[e]);if(!f){return}c("<img />").load(function(){var j=this.width,h=this.height,r,i,g;if(!a.list||!j||!h){return}r=j/k;i=h/l;g=a.list.children().eq(e).find("a");if(r>=1&&i>=1){if(r>i){j=Math.floor(j/i);h=l}else{j=k;h=Math.floor(h/r)}}c(this).css({width:j,height:h,top:Math.floor(l/2-h/2),left:Math.floor(k/2-j/2)});g.width(k).height(l);c(this).hide().appendTo(g).fadeIn(300)}).attr("src",f)});this.width=this.list.children().eq(0).outerWidth(true);this.list.width(this.width*(p.group.length+1)).css("left",Math.floor(c(window).width()*0.5-(p.index*this.width+this.width*0.5)))},beforeLoad:function(b,a){if(a.group.length<2){a.helpers.thumbs=false;return}a.margin[b.position==="top"?0:2]+=((b.height||50)+15)},afterShow:function(b,a){if(this.list){this.onUpdate(b,a)}else{this.init(b,a)}this.list.children().removeClass("active").eq(a.index).addClass("active")},onUpdate:function(b,a){if(this.list){this.list.stop(true).animate({left:Math.floor(c(window).width()*0.5-(a.index*this.width+this.width*0.5))},150)}},beforeClose:function(){if(this.wrap){this.wrap.remove()}this.wrap=null;this.list=null;this.width=0}}}(jQuery));