$(document).ready(function () {
    var tabi = 1;
    var imgid;//与TAB焦点同步

    function addtabimg() {
        $('.closetab').remove();
        $("#container ul li").each(function (i) {
            var str = "<img src='images/tab-close.gif' align='absmiddle' id='" + i + "' class='closetab' />";
            $(this).append(str);
            imgid = i + 1;
        });
        $(".closetab", $("#container ul li:first")).css({
            visibility: "hidden"
        });//.remove();
        $('.closetab').click(function () {
            $("#container ul").tabsRemove(parseInt($(this).attr("id")) + 1);
        });
    }
    addtabimg();
    //加入关闭tabs按钮.tabclose 结束
    // tabs	
    $('#container ul').tabs({
        event: 'click',
        fxFade: false,
        fxSpeed: 'fast',
        cache: false,	//是否缓存页面
        idPrefix: 'tabs',
        click: function () {
        },
        hide: function () {
        },
        show: function () {
        },
        add: function () {
            addtabimg();
            $("#container ul").tabsClick(imgid);//获得TAB焦点
        },
        remove: function () {
            addtabimg();
        }
    });
    // tabs end

    //add tabs
    $("li a", $(".fun_title")).each(function (i) {
        var objId = this.id;
        var objTitle = this.title;
        var rel = this.rel;
        var fileName = "../main/content?url=" + rel;

        $(this).bind("click", function () {
            var title = $(this).attr('title');
            var newtab;
            $('span', $('#container ul li')).each(function (i) {
                if (title == $(this).text()) {
                    clicktab = parseInt($(this).parent().siblings('img').attr('id')) + 1;
                    $("#container ul").tabsClick(clicktab);
                    newtab = 1;
                }
            });
            if (newtab != 1) {
                $("#container ul").tabsAdd(fileName, objTitle);
            }
        });
    });

    //removetabs
    $('.closetab').click(function () {
        if (parseInt($(this).attr("id")) > 1) {
            $("#container ul").tabsRemove(parseInt($(this).attr("id")) + 1);
        }
    });
//测试代码开始
});

