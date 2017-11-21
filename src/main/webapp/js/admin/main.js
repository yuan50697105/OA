$(document).ready(function() {
	$("#t_item_1").addClass("item_move");
	$(".panel_head ul li").click(function() {
		$(this).addClass("item_move");
	});
	/* 企业设置 */
	$(".enter_infor").addClass('bg');
	$(".enter_infor").click(function() {
		$(".enter_infor").addClass('bg');
		$(".enter_set").removeClass('bg');
		$(".infor_show").show();
		$(".infor_set").hide();
	});
	$(".enter_set").click(function() {
		$(".enter_set").addClass('bg');
		$(".enter_infor").removeClass('bg');
		$(".infor_show").hide();
		$(".infor_set").show();
	});
});