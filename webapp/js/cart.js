
/**
 * 加入购物车
 */
function buy(goodsid) {
	$.post("goods_buy", { goodsid: goodsid }, function(data) {
		if (data == "ok") {
			layer.msg("添加购物车成功!", { time: 800 }, function() {
				location.reload();
			});
		} else {
			alert("请求失败!");
		}
	});
}
/**
 * 购物车减去
 */
function lessen(goodsid) {
	$.post("goods_lessen", { goodsid: goodsid }, function(data) {
		if (data == "ok") {
			layer.msg("减少购买数成功!", { time: 800 }, function() {
				location.reload();
			});
		} else {
			alert("请求失败!");
		}
	});
}
/**
 * 购物车删除
 */
function deletes(goodsid) {
	$.post("goods_delete", { goodsid: goodsid }, function(data) {
		if (data == "ok") {
			layer.msg("删除商品成功!", { time: 800 }, function() {
				location.reload();
			});
		} else {
			alert("请求失败!");
		}
	});
}