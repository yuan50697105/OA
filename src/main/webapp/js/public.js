/*
 * Translated default messages for the jQuery validation plugin. Language: CN
 * Author:
 */
jQuery.extend(jQuery.validator.messages, {
    required: "不能为空",
    remote: "请修正该字段",
    email: "邮件格式不正确",
    url: "网址不合法",
    date: "日期不合法",
    dateISO: "请输入合法的日期",
    number: "只能输入数字",
    digits: "只能输入整数",
    creditcard: "请输入合法的信用卡号",
    equalTo: "请再次输入相同的值",
    accept: "请输入拥有合法后缀名的字符串",
    maxlength: jQuery.validator.format("长度最多是 {0}"),
    minlength: jQuery.validator.format("长度最少是 {0}"),
    rangelength: jQuery.validator.format("长度须介于 {0} 和 {1} 之间"),
    range: jQuery.validator.format("大小须介于 {0} 和 {1} 之间"),
    max: jQuery.validator.format("最大值为 {0} 的值"),
    min: jQuery.validator.format("最小值为 {0} 的值")
});

// 可以验证 2011-07-07和2011/07/07两种短横线和斜杠格式
jQuery.validator.addMethod("isDate", function (value, element) {
    if (value == null || value == '') {
        return true;
    }
    var reg = /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/;
    var r = value.match(reg);
    if (r == null) {
        return false;
    }
    var d = new Date(r[1], r[3] - 1, r[5]);
    var result = (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d
        .getDate() == r[5]);
    return this.optional(element) || (result);
}, "请输入正确的日期");

function toggle_editor(id) {
    if (!tinyMCE.getInstanceById(id))
        tinyMCE.execCommand("mceAddControl", false, id);
    else
        tinyMCE.execCommand("mceRemoveControl", false, id);
}

function tabColor() {
    var x = "bgColorWa";
    var z = "bgColorYa";
    var tab = document.getElementsByTagName("TABLE");
    for (var n = 0; n < tab.length; n++) {
        if (tab[n].className == "formContent") {
            var tabTr = tab[n].getElementsByTagName("tr");
            for (var m = 0; m < tabTr.length; m++) {
                tabTr[m].className = (tabTr[m].sectionRowIndex % 2 == 0)
                    ? z
                    : x;
            }
        }
        if (tab[n].className == "listContent") {
            var tabTr = tab[n].getElementsByTagName("tr");
            for (var m = 0; m < tabTr.length; m++) {
                tabTr[m].className = (tabTr[m].sectionRowIndex % 2 == 0)
                    ? z
                    : x;
            }
        }
    }
}

function checkAll(checkbox, name) {
    if (checkbox.checked) {
        $("input[name=" + name + "]").attr("checked", true);
    } else {
        $("input[name=" + name + "]").attr("checked", false);
    }
}

// 自动完成
function autocompleteUser(pyInputId, userNameId, userDlId, userOrgCodeId,
                          userOrgDescId) {
    $("input#" + pyInputId).autocomplete({
        minLength: 1,
        source: function (request, response) {
            $.post(endPoint + "/tags/tag_users", {
                pym: request.term
            }, function (data) {
                response($.map(data, function (item) {
                    return {
                        label: item.userName,
                        value: item.pym,
                        code: item.userDl,
                        orgId: item.hospId,
                        orgName: item.hospName
                    };
                }));
            });
        },
        select: function (event, ui) {
            $("#" + userNameId).val(ui.item.label);
            $("#" + userDlId).val(ui.item.code);
            $(this).val(ui.item.value);
            if (userOrgDescId != '' && userOrgCodeId != '') {
                $("#" + userOrgDescId).val(ui.item.orgName);
                $("#" + userOrgCodeId).val(ui.item.orgId);
            }
            return false;
        }
    });
}

// 行政机构下拉
function xzjg(xianName, xiangName, cunName) {
    var xianSelect = $("#" + xianName.replace(/\./gi, "_"));
    var xiangSelect = $("#" + xiangName.replace(/\./gi, "_"));
    var cunSelect = $("#" + cunName.replace(/\./gi, "_"));
    xianSelect.change(function () {
        var xianValue = $(this).val();
        if (xianValue != "") {
            $.post(endPoint + "/tags/org_getXiang", {
                xianId: xianValue
            }, function (data) {
                if (data.length != 0) {
                    xiangSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].hospId
                            + "'>" + data[i].hospName
                            + "</option>")
                            .appendTo(xiangSelect);
                    }
                    cunSelect
                        .html("<option value=''>请选择</option>");
                } else {
                    xiangSelect
                        .html("<option value=''>请选择</option>");
                    cunSelect
                        .html("<option value=''>请选择</option>");
                }
            });
        } else {
            xiangSelect.html("<option value=''>请选择</option>");
            cunSelect.html("<option value=''>请选择</option>");
        }
    });
    xiangSelect.change(function () {
        var xiangValue = $(this).val();
        if (xiangValue != "") {
            $.post(endPoint + "/tags/org_getCun", {
                xiangId: xiangValue
            }, function (data) {
                if (data.length != 0) {
                    cunSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].hospId
                            + "'>" + data[i].hospName
                            + "</option>")
                            .appendTo(cunSelect);
                    }
                }
            });
        } else {
            cunSelect.html("<option value=''>请选择</option>");
        }
    });
}

// 行政机构下拉(四级)
function xzjgz(xianName, xiangName, cunName, zuName) {
    var xianSelect = $("#" + xianName.replace(/\./gi, "_"));
    var xiangSelect = $("#" + xiangName.replace(/\./gi, "_"));
    var cunSelect = $("#" + cunName.replace(/\./gi, "_"));
    var zuSelect = $("#" + zuName.replace(/\./gi, "_"));
    xianSelect.change(function () {
        var xianValue = $(this).val();
        if (xianValue != "") {
            $.post(endPoint + "/tags/org_getXiang", {
                xianId: xianValue
            }, function (data) {
                if (data.length != 0) {
                    xiangSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].hospId
                            + "'>" + data[i].hospName
                            + "</option>")
                            .appendTo(xiangSelect);
                    }
                    cunSelect
                        .html("<option value=''>请选择</option>");
                    zuSelect
                        .html("<option value=''>请选择</option>");
                } else {
                    xiangSelect
                        .html("<option value=''>请选择</option>");
                    cunSelect
                        .html("<option value=''>请选择</option>");
                    zuSelect
                        .html("<option value=''>请选择</option>");
                }
            });
        } else {
            xiangSelect.html("<option value=''>请选择</option>");
            cunSelect.html("<option value=''>请选择</option>");
            zuSelect.html("<option value=''>请选择</option>");
        }
    });
    xiangSelect.change(function () {
        var xiangValue = $(this).val();
        if (xiangValue != "") {
            $.post(endPoint + "/tags/org_getCun", {
                xiangId: xiangValue
            }, function (data) {
                if (data.length != 0) {
                    cunSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].hospId
                            + "'>" + data[i].hospName
                            + "</option>")
                            .appendTo(cunSelect);
                    }
                    zuSelect
                        .html("<option value=''>请选择</option>");
                } else {
                    cunSelect
                        .html("<option value=''>请选择</option>");
                    zuSelect
                        .html("<option value=''>请选择</option>");
                }
            });
        } else {
            cunSelect.html("<option value=''>请选择</option>");
            zuSelect.html("<option value=''>请选择</option>");
        }
    });
    cunSelect.change(function () {
        var cunValue = $(this).val();
        if (cunValue != "") {
            $.post(endPoint + "/tags/org_getZu", {
                cunId: cunValue
            }, function (data) {
                if (data.length != 0) {
                    zuSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].hospId
                            + "'>" + data[i].hospName
                            + "</option>")
                            .appendTo(zuSelect);
                    }
                }
            });
        } else {
            zuSelect.html("<option value=''>请选择</option>");
        }
    });
}

// 医疗机构
function org(xianName, xiangName, cunName) {
    var xianSelect = $("#" + xianName.replace(/\./gi, "_"));
    var xiangSelect = $("#" + xiangName.replace(/\./gi, "_"));
    var cunSelect = $("#" + cunName.replace(/\./gi, "_"));
    xianSelect.change(function () {
        var xianValue = $(this).val();
        if (xianValue != "") {
            $.post(endPoint + "/tags/org_getXiangOrg", {
                xianId: xianValue
            }, function (data) {
                if (data.length != 0) {
                    xiangSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].hospId
                            + "'>" + data[i].hospName
                            + "</option>")
                            .appendTo(xiangSelect);
                    }
                    cunSelect
                        .html("<option value=''>请选择</option>");
                }
            });
        } else {
            xiangSelect.html("<option value=''>请选择</option>");
            cunSelect.html("<option value=''>请选择</option>");
        }
    });

    xiangSelect.change(function () {
        var xiangValue = $(this).val();
        if (xiangValue != "") {
            $.post(endPoint + "/tags/org_getCunOrg", {
                xiangId: xiangValue
            }, function (data) {
                if (data.length != 0) {
                    cunSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].hospId
                            + "'>" + data[i].hospName
                            + "</option>")
                            .appendTo(cunSelect);
                    }
                }
            });
        } else {
            cunSelect.html("<option value=''>请选择</option>");
        }
    });
}

// 只允许选择本机构 ,以及下属机构 .
// 只针对县乡两级 , 不涉及到村
function orgXianXiangWithAuth(xiangName, defaultXiangCode) {
    var xiangSelect = $("#" + xiangName.replace(/\./gi, "_"));
    xiangSelect.change(function () {
        if (defaultXiangCode != '') {
            xiangSelect.val(defaultXiangCode);
        }
    });
}

// 科室
function keshi(orgId, keShiId) {
    var orgSelect = $("#" + orgId);
    var keshiSelect = $("#" + keShiId);
    orgSelect.change(function () {
        var orgValue = $(this).val();
        if (orgValue != "") {
            $.post(endPoint + "/tags/tag_keshi", {
                hospId: orgValue
            }, function (data) {
                if (data.length != 0) {
                    keshiSelect.html("");
                    $("<option value=''>请选择</option>")
                        .appendTo(keshiSelect);
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].ksbm
                            + "'>" + data[i].ksmc
                            + "</option>")
                            .appendTo(keshiSelect);
                    }
                }
            });
        } else {
            keshiSelect.html("");
            $("<option value=''>请选择</option>").appendTo(keshiSelect);
        }
    });

}

// 下拉 初始化 、 及事件处理
function bcsrSelect(selectId, bcsrId, bcsrCode) {
    var select = $("#" + selectId);
    var bcsr = "";
    if (bcsrId != "" && bcsrId != null) {
        bcsr = $("#" + bcsrId);
        // 初始化补充输入框是否显示
        if (select.val() == bcsrCode) {
            bcsr.show("slow");
        } else {
            bcsr.hide("slow");
        }
    }
    // 下拉改变事件
    select.change(function () {
        if (bcsrId != "" && bcsrId != null) {
            if ($(this).val() == bcsrCode) {
                bcsr.show("slow");
            } else {
                bcsr.val();
                bcsr.hide("slow");
            }
        }
    });
}

// 单选按钮组 初始化 、 及事件处理
function bcsrRadio(radioName, bcsrId, bcsrCode) {
    var group = $("input[name='" + radioName + "']");
    var bcsr = "";
    if (bcsrId != "" && bcsrId != null) {
        bcsr = $("#" + bcsrId);
        var check = $("[name='" + radioName + "']:radio:checked");
        if (check.length > 0 && check.val() == bcsrCode) {
            bcsr.show("slow");
        } else {
            bcsr.val("");
            bcsr.hide("slow");
        }
    }

    // 下拉改变事件
    group.each(function () {
        $(this).click(function () {
            if (bcsrId != "" && bcsrId != null) {
                if ($(this).val() == bcsrCode
                    && $(this).attr("checked") == true) {
                    bcsr.show("slow");
                } else {
                    bcsr.val("");
                    bcsr.hide("slow");
                }
            }
        });
    });
}

// 获取服务端生成的 tr td ,并生成 div 及 table ,此处没有完善的异步处理框架 ，只能预先查询数据库生成tr td 对象
function createDivForCheckBox(divId, type, innerTrHtml, checkBoxGropName,
                              bcsrName, codeInputName, descInputName, divSubmitButton) {

    // 获取json字符串 并转换为 json对象
    var type = eval("(" + type + ")")[0];
    var codes = type.gwJbdm02List;

    var showdiv = document.createElement("div");
    $(showdiv).attr("id", divId);
    $(showdiv).attr("title", type.dmlb02);

    var innerHtml = "";
    innerHtml = innerHtml
        + '<table id="table_checkbox_id" width="100%" class="listContent contentDiv">';
    innerHtml = innerHtml + innerTrHtml;
    innerHtml = innerHtml
        + '<tr><td align="center" colspan="3"><input type="button" id="'
        + divSubmitButton
        + '" value=" 确 定 " class="input_button"/></td></tr>';
    innerHtml = innerHtml + "</table>";
    showdiv.innerHTML = innerHtml;

    // 弹出窗口
    $(showdiv).dialog({
        modal: true,
        show: "slide",
        hide: "blind",
        close: function (event, ui) {
            $(this).dialog("close");
            $(showdiv).remove();
        }
    });
    // 初始化 及 事件绑定
    bindEventForCheckBox(codes, checkBoxGropName, bcsrName, codeInputName,
        descInputName, divId, divSubmitButton);

}

// 初始化 及 事件绑定
function bindEventForCheckBox(codes, checkBoxGropName, bcsrName, codeInputName,
                              descInputName, divId, divSubmitButton) {
    var codeInput = $("input[name='" + codeInputName + "']");
    var checkBoxGroupInput = $("#" + divId + " input[name='" + checkBoxGropName
        + "']");
    var checkedDescInput = $("#" + descInputName.replace(".", "_"));
    var bcsrInput = $("#" + bcsrName);
    var buttonOk = $("#" + divSubmitButton);

    // 筛选出 排他 和 其它 代码的 基本代码
    var ptCode = "";
    var qtCode = "";
    for (var i = 0; i < codes.length; i++) {
        var code = codes[i];
        if (code.jbdm05 == '2') {
            ptCode = code.jbdm01;
        }
        if (code.srbz01 == '2' || code.srbz01 == '3') {
            qtCode = code.jbdm01;
        }
    }
    // 初始化是否选中
    var values = codeInput.val().split(",");
    if (values != "" && values != null) {
        for (var i = 0; i < values.length; i++) {
            if (values[i] != "" && values[i] != "") {
                $("#" + divId + " input[name='" + checkBoxGropName
                    + "'][value='" + values[i] + "']")
                    .attr("checked", true);
            }
        }
    }

    // 初始化排他项选中，则其它checkbox disable
    if (ptCode != null && ptCode != "") {
        $("#" + divId + " input[name='" + checkBoxGropName + "']:checked")
            .each(function () {
                if ($(this).val() == ptCode) {
                    checkBoxGroupInput.each(function () {
                        if ($(this).val() != ptCode) {
                            $(this).attr({
                                checked: false,
                                disabled: "disabled"
                            });
                        }
                    });
                }
            });
    }
    // checkbox 单击,判断是否选中排他选项
    if (ptCode != null && ptCode != "") {
        $("#" + divId + " input[name='" + checkBoxGropName + "'][value='"
            + ptCode + "']").click(function () {
            if ($(this).attr("checked")) {
                checkBoxGroupInput.each(function () {
                    if ($(this).val() != ptCode)
                        $(this).attr({
                            checked: false,
                            disabled: "disabled"
                        });
                });
            } else {
                checkBoxGroupInput.each(function () {
                    if ($(this).val() != ptCode)
                        $(this).removeAttr("disabled");
                });
            }
        });
    }

    // 点击确定按钮，生成自动 选中的代码串 和描述串
    buttonOk.click(function () {
        // 生成字符串
        var codeString = "";
        var descString = "";
        var checks = $("#" + divId + " input[name='" + checkBoxGropName
            + "']:checked");
        checks.each(function () {
            codeString += (codeString == "" ? "" : ",")
                + $(this).parent().parent().find("input")
                    .val();
            descString += (descString == "" ? "" : ",")
                + $("td:eq(1)", $(this).parent().parent())
                    .text();
        });
        codeInput.val(codeString);
        checkedDescInput.val(descString);

        // 其它按钮是否选中
        var qtChecked = $("#" + divId + " input[name='"
            + checkBoxGropName + "'][value='" + qtCode + "']")
            .attr("checked");
        if (qtChecked) {
            bcsrInput.show("slow");
        } else {
            bcsrInput.hide("slow");
            bcsrInput.val("");
        }
        $("#" + divId).remove();
    });
}

function showModal(url, width, height) {
    if (width == '') {
        width = screen.width;
    }
    if (height == '') {
        height = screen.height;
    }
    window.showModalDialog(url, '', 'dialogWidth=' + width + 'px;dialogHeight='
        + height + 'px;resizable:yes');
}

function openWindow(url, width, height) {
    if (width == '') {
        width = screen.width;
    }
    if (height == '') {
        height = screen.height;
    }
    var win = window.open(url, '', 'height=' + height + 'px,width=' + width
        + 'px,resizable=yes,toolbar:0,menubar:0,scrollbars=1');
    return win;
}

// 表单美化
function formReset() {
    // Input text
    if ($("input").attr("readOnly") == true) {
        $(":text,:password").addClass("input_text_readonly");
    } else {
        $(":text,:password").addClass("input_text");
        $(":text,:password").hover(function () {
            $(this).addClass("input_text_hover")
        }, function () {
            $(this).removeClass("input_text_hover")
        });
        $(":text,:password").focus(function () {
            $(this).addClass('input_text_click')
        });
        $(":text,:password").blur(function () {
            $(this).removeClass('input_text_click')
        });
    }
    ;

    // hidden
    // $(":hidden").addClass("input_text_hidden");

    // Input button
    $(":submit,:reset,:button").addClass("input_button");
    $(":submit,:reset,:button").hover(function () {
        $(this).addClass("input_button_hover")
    }, function () {
        $(this).removeClass("input_button_hover")
    });
    $(":submit,:reset,:button").mousedown(function () {
        $(this).addClass('input_button_click')
    });
    $(":submit,:reset,:button").mouseup(function () {
        $(this).removeClass('input_button_click')
    });
    // Textarea
    $("textarea").addClass("input_textarea");
    $("textarea").hover(function () {
        $(this).addClass("input_textarea_hover")
    }, function () {
        $(this).removeClass("input_textarea_hover")
    });
    $("textarea").focus(function () {
        $(this).addClass('input_textarea_click')
    });
    $("textarea").blur(function () {
        $(this).removeClass('input_textarea_click')
    });
}

function pagesChange(_this, _val) {
    if (_val == '') {
        alert('请输入正确的页码');
    } else {
        var curPage = _this.parents("form").find("input[name='pages.curPage']");
        curPage.val(_val);
        _this.parents("form").submit();
    }
}

function setPageReadonly() {
    $("select").focus(function () {
        $(this).attr('defaultVal', $(this).val());
    });
    $("select").change(function () {
        $(this).val($(this).attr('defaultVal'));
    });
    $("input").attr("readonly", "readonly");
    $("input").unbind("focus");
    $("textarea").attr("readonly", "readonly");
    $("input[type='submit']").unbind("click");
    $("input[type='button']").each(function () {
        $(this).unbind("click");
    });
    $("form").unbind("submit");
    $("form").submit(function () {
        return false;
    });
}

function showGgcs02(xzjg01, gylx01, ywbm01, targetId) {
    // 参数_this == button ; xzjg01 = 行政机构 ; gylx01==干预类型（1指导意见；2干预措施;3健教处方）;
    // ywbm01 == 业务编码 ; targetId == 字符串输出位置 ;
    $.post(endPoint + "/tags/tag_ggcs", {
        xzjg01: xzjg01,
        gylx01: gylx01,
        ywbm01: ywbm01
    }, function (jsonArray) {
        // 创建DIV
        var showdiv = document.createElement("div");
        // div的title（dialog的显示标题）
        if (gylx01 == '1')
            $(showdiv).attr("title", "指导意见");
        else if (gylx01 == '2')
            $(showdiv).attr("title", "干预措施");
        else
            $(showdiv).attr("title", "健教处方");

        // 对话框显示的元素
        var html = '<table width="100%" class="listContent contentDiv">';
        // 隐藏的元素
        var valueHtml = "";
        // 布局四列 , 两列checkbox 两列 处方信息
        for (var i = 0; i < jsonArray.length; i++) {
            // 两列
            var checkBoxHtml = '<input type="checkbox" value="'
                + jsonArray[i].nbxh01 + '"/>';
            var textHtml = jsonArray[i].cfxx01;
            html = html + '<tr><td>' + checkBoxHtml + '</td><td>'
                + textHtml + '</td>';
            valueHtml = valueHtml + '<div id="' + jsonArray[i].nbxh01
                + '" style="display:none">' + jsonArray[i].cfxx02
                + '</div>';
            // 两列
            i = i + 1;
            if (i < jsonArray.length) {
                checkBoxHtml = '<input type="checkbox" value="'
                    + jsonArray[i].nbxh01 + '"/>'
                textHtml = jsonArray[i].cfxx01;
                html = html + '<td>' + checkBoxHtml + '</td><td>'
                    + textHtml + '</td></tr>';
                valueHtml = valueHtml + '<div id="'
                    + jsonArray[i].nbxh01
                    + '" style="display:none">'
                    + jsonArray[i].cfxx02 + '</div>';
            } else {
                if (i == 1)
                    html = html + '<td></td><td></td></tr>';
                else
                    html = html + '</tr>';
            }
        }
        html = html + '</table>';
        // 确定按钮
        html = html + '<div><input type="button" value="确 定"/></div>';

        // div内容
        $(showdiv).html(html + valueHtml);
        // 绑定事件
        $(showdiv).find("input[type='button'][value='确 定']").click(
            function () {
                var text = "";// 选中的内容
                $('#' + targetId).length;
                $(showdiv).find(":checked").each(function () {
                    text = text
                        + $(showdiv).find('[id="'
                            + $(this).val() + '"]').text();
                    text = text + "\n";
                });
                if (text.length > 4000)
                    text = text.substr(0, 3999);
                $('#' + targetId).val($('#' + targetId).val()
                    + text);
                $(showdiv).dialog("close");
            });

        // 弹出对话框
        $(showdiv).dialog({
            modal: true,
            show: "slide",
            hide: "blind",
            width: "400px",
            close: function (event, ui) {
                $(showdiv).remove();
            }
        });

    });
}

// 高危评分
function gwpf(scoreId, valueId) {
    var showdiv = document.createElement("div");
    $(showdiv).attr("title", "孕产妇-高危评分");
    var pf = $("#" + scoreId).val();
    var ch = $("#" + valueId).val();
    $.post(endPoint + "/ycf/fnbj_ycf_pf_ajax.jsp", '', function (html) {
        $(showdiv).html(html);
        $(showdiv).find("#_ok").click(function () {
            var leftScore = $("#leftScore").val();
            var rightScore = $("#rightScore").val();
            var total = Number(leftScore) + Number(rightScore);
            $("#" + scoreId).val(total);
            ch = "";
            $("#gwystable").find(":checkbox").each(function () {
                if ($(this).attr("checked")) {
                    if (ch == '') {
                        ch += $(this).attr("id");
                    } else {
                        ch += "," + $(this).attr("id");
                    }
                }
            });
            $("#" + valueId).val(ch);
            $(showdiv).dialog("close");
            $(showdiv).remove();
        });
        // 弹出对话框
        $(showdiv).dialog({
            modal: true,
            show: "slide",
            hide: "blind",
            width: 800,
            height: $(window).height() * 0.8,
            close: function (event, ui) {
                $(showdiv).remove();
            }
        });

        $("#gwystable").find(":checkbox").each(function () {
            $(this).change(function () {
                var leftScore = $("#leftScore").val();
                var rightScore = $("#rightScore").val();
                if ($(this).attr("checked")) {
                    if ($(this).attr("name") == "left") {
                        leftScore = Number(leftScore) + Number($(this).val());
                    } else {
                        rightScore = Number(rightScore) + Number($(this).val());
                    }
                } else {
                    if ($(this).attr("name") == "left") {
                        leftScore = Number(leftScore) - Number($(this).val());
                    } else {
                        rightScore = Number(rightScore) - Number($(this).val());
                    }
                }
                $("#leftScore").val(leftScore);
                $("#rightScore").val(rightScore);
            });
        });

        $("#" + scoreId).val(pf);
        if (ch != '') {
            var arr = ch.split(",");
            var leftScore = $("#leftScore").val();
            var rightScore = $("#rightScore").val();
            for (var i = arr.length - 1; i >= 0; i--) {
                $("#" + arr[i]).attr("checked", true);
                if ($("#" + arr[i]).attr("name") == "left") {
                    leftScore = Number(leftScore)
                        + Number($("#" + arr[i]).val());
                } else {
                    rightScore = Number(rightScore)
                        + Number($("#" + arr[i]).val());
                }
            }
            $("#leftScore").val(leftScore);
            $("#rightScore").val(rightScore);
        }
    });
}

// 选择的登记机构
function findSelectOrgId(xianName, xiangName, cunName) {
    var xianOrgId = $("select[name='" + xianName + "']").val();
    var xiangOrgId = $("select[name='" + xiangName + "']").val();
    var cunOrgId = $("select[name='" + cunName + "']").val();
    var org;
    if (cunOrgId != null && cunOrgId != '') {
        org = cunOrgId;
    } else if (xiangOrgId != null && xiangOrgId != '') {
        org = xiangOrgId;
    } else if (xianOrgId != null && xianOrgId != '') {
        org = xianName;
    } else {
        org = '';
    }
    return org;
}

// 选择的行政机构
function findSelectXzjgId(xian, xiang, cun) {
    var xianId = $("select[name='" + xian + "']").val();
    var xiangId = $("select[name='" + xiang + "']").val();
    var cunId = $("select[name='" + cun + "']").val();
    var xzjg;
    if (cunId != null && cunId != '') {
        xzjg = cunId;
    } else if (xiangId != null && xiangId != '') {
        xzjg = xiangId;
    } else if (xianId != null && xianId != '') {
        xzjg = xianId;
    } else {
        xzjg = '';
    }
    return xzjg;
}


$(function () {
    formReset();
    tabColor();
    //$(':input:not(:hidden):not(:button):first').focus();
    var first = $(':input:not(:hidden):not(:submit):not(:button):first');
    if (first.length > 0) {
        first.focus();
    }
    if ($.browser.msie) {
        document.onkeydown = function enterToTab() {
            if (event.srcElement.type != 'button' && event.srcElement.type != 'submit' && event.srcElement.type != "image" && event.srcElement.type != 'textarea' && event.keyCode == 13) {
                event.keyCode = 9;
            }
        }
    }

});

// 下次随访计划，
// active_xcsfrq:计划修改后的最近一次随访时间
// active_hdxh01:当前表单对应的ywsj03表的hdxh01
function hd_xcsfrq(active_xcsfrq, active_hdxh01) {
    $("#" + active_xcsfrq).attr("readOnly", "");
    $("#" + active_xcsfrq).datepicker({
        changeYear: true,
        changeMonth: true
    });
    $("#" + active_xcsfrq).focus();
// 暂时不使用
    /*
         * var showdiv =document.createElement("div"); var nbxh01 =
         * $("#"+active_hdxh01).val(); $(showdiv).attr("title","服务计划-计划列表"); $.post(
         * endPoint + "/tags/tag_hdlist", {'nbxh01':nbxh01}, function(html){
         * $(showdiv).html(html); $(showdiv).dialog({ modal:true, show: "slide",
         * hide: "blind", width:800, height:$(window).height()*0.8,
         * close:function(event, ui) { $(showdiv).remove() ; } });
         * $(showdiv).find("#_ok").click(function(){ var list = new Array();
         * $("#EventActivity_table").find("tr").each(function(){
         * if($(this).find(":input[type='text']").length > 0 ) { var obj = [];
         * $(this).find(":input").each(function(){ obj.push($(this).val()); });
         * list.push(obj); } }); $.post( endPoint+'/tags/tag_saveHdlist',
         * {'nbxh01':nbxh01,'date':list.join("#")}, function(obj){
         * $("#"+active_xcsfrq).val(obj.sfrq01); $(showdiv).dialog("close");
         * $(showdiv).remove() ; } );
         *  }) } );
         */
}

$(function () {
    formReset();
    tabColor();
    // $(':input:not(:hidden):not(:button):first').focus();
    var first = $(':input:not(:hidden):not(:submit):not(:button):first');
    if (first.length > 0) {
        first.focus();
    }
    // document.title = " OAS办公系统";

    if ($.browser.msie) {
        document.onkeydown = function enterToTab() {
            if (event.srcElement.type != 'submit'
                && event.srcElement.type != "image"
                && event.srcElement.type != 'textarea'
                && event.keyCode == 13) {
                event.keyCode = 9;
            }
        }
    }

});

// 指标分类下拉
function zbssfl(zbflName, ssflName) {
    var zbflSelect = $("#" + zbflName.replace(/\./gi, "_"));
    var ssflSelect = $("#" + ssflName.replace(/\./gi, "_"));
    zbflSelect.change(function () {
        var flbmValue = $(this).val();
        if (flbmValue != "") {
            if (flbmValue == '1') {
                flbmValue = "gw";
            } else if (flbmValue == '2') {
                flbmValue = "yl";
            } else if (flbmValue == '3') {
                flbmValue = "nh";
            }
            $.post(endPoint + "/tags/tag_getSsfl", {
                flbm: flbmValue
            }, function (data) {
                if (data.length != 0) {
                    ssflSelect
                        .html("<option value=''>请选择</option>");
                    for (var i = 0; i < data.length; i++) {
                        $("<option value='" + data[i].flbm01
                            + "'>" + data[i].flmc01
                            + "</option>")
                            .appendTo(ssflSelect);
                    }
                } else {
                    ssflSelect
                        .html("<option value=''>请选择</option>");
                }
            });
        } else {
            ssflSelect.html("<option value=''>请选择</option>");
        }
    });
}


function show_pfgz(pfgzbm, seleted) {
    $.post(endPoint + "/tags/tag_getPfgz", {
        pfgzbm: pfgzbm
    }, function (jsonArray) {
        // 创建DIV
        var showdiv = document.createElement("div");
        $(showdiv).attr("title", "评分细则信息");
        // 对话框显示的元素
        var html = '<table width="100%" class="listContent contentDiv">';
        for (var i = 0; i < jsonArray.length; i++) {
            if (jsonArray.length > 15) {

                var str = '|' + jsonArray[i].nbxh01 + '|';
                if (seleted.indexOf(str) > 0) {
                    html += '<tr><td><img src="../common/images/tipsSuccess.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td>';
                } else {
                    html += '<tr><td><img src="../common/images/tipsError.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td>';
                }
                if (i + 1 < jsonArray.length) {
                    i++;
                    str = '|' + jsonArray[i].nbxh01 + '|';
                    if (seleted.indexOf(str) > 0) {
                        html += '<td><img src="../common/images/tipsSuccess.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td>';
                    } else {
                        html += '<td><img src="../common/images/tipsError.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td>';
                    }
                    if (i + 1 < jsonArray.length) {
                        i++;
                        str = '|' + jsonArray[i].nbxh01 + '|';
                        if (seleted.indexOf(str) > 0) {
                            html += '<td><img src="../common/images/tipsSuccess.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td></tr>';
                        } else {
                            html += '<td><img src="../common/images/tipsError.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td></tr>';
                        }
                    } else {
                        html += '</tr>'
                    }
                } else {
                    html += '</tr>'
                }
            } else {
                var str = '|' + jsonArray[i].nbxh01 + '|';
                if (seleted.indexOf(str) > 0) {
                    html += '<tr><td><img src="../common/images/tipsSuccess.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td></tr>';
                } else {
                    html += '<tr><td><img src="../common/images/tipsError.gif"/>' + jsonArray[i].sxmc01 + '</td><td>' + (jsonArray[i].yxj001 == '0' ? jsonArray[i].sxzx01 : jsonArray[i].df0001) + '</td></tr>';
                }
            }
        }
        html += '</table>';
        // div内容
        $(showdiv).html(html);
        // 弹出对话框
        $(showdiv).dialog({
            modal: true,
            show: "slide",
            hide: "blind",
            width: 640,
            height: 480,
            buttons: {
                " 关 闭 ": function () {
                    $(showdiv).dialog("close");
                }
            },
            close: function (event, ui) {
                $(showdiv).remove();
            }
        });

    });
}
