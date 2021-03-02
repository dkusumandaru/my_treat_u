function getDataId(id, status){
	if (status == 'member') {
		var data = resultMembers[0];
		for (var i = 0; i < data.length; i++) {
			if (id == data[i].id_member) {
				return data[i];
			}
		}
	}else if(status == 'item'){
		var data = resultItems[0];
		for (var i = 0; i < data.length; i++) {
			if (id == data[i].id_item) {
				return data[i];
			}
		}
	}else if(status == 'discount'){
		var data = resultDiscounts[0];
		for (var i = 0; i < data.length; i++) {
			if (id == data[i].id_discount) {
				return data[i];
			}
		}
	}else{
		return false;
	}
}

function checkDataId(id, status){
	if (status == 'item') {
		if (useItems.length > 0) {
			var data = useItems;
			// 
			for (var i = 0; i < data.length; i++) {
				if (id == data[i].id_item) {
					return false;
				}
			}
			return true;
		}else{
			return true;
		}
	}else if (status == 'discount') {
		if (useDiscount.length > 0) {
			var data = useDiscount;
			// 
			for (var i = 0; i < data.length; i++) {
				if (id == data[i].id_discount) {
					return false;
				}
			}
			return true;
		}else{
			return true;
		}
	}
}

function removeDataId(id){
	var data = useItems[0];
	var indexItem = useItems.indexOf(data);
	useItems.splice(indexItem, 1);
}



var memberFrame = [
	'<div id="member_box_', //id_member'
	'" class="col-md-12 col-sm-12 col-12"><div class="info-box">',
	'" class="col-md-12 col-sm-12 col-12"><div class="info-box">',
			'<span class="info-box-icon"><i class="far fa-user-circle fa-lg"></i></span>',
			'<div class="info-box-content">',
				'<span class="info-box-text"><i>id.', //id_member
				'</i></span>',
				'<span class="info-box-text"><b>', //Name
				'</b></span>',
				'<span class="info-box-text"><i>', //Phone
				'</i></span>',
			'</div><div class="info-box-icon">',
				'<button class="btn btn-success btn-lg" onclick="chooseMember(&#39;', //id
				'&#39;)"> <span class="fas fa-check"></span>',
				'</button>',
	'</div></div></div>',
	'<center><button class="btn btn-sm btn-info" type="button" data-toggle="modal" data-target="#addMember"><span class="fa fa-plus-circle"></span> Tambah Member</button></center><br>',
	'<center class="col-md-12"><div>Member <b> : <u>',
	'</u></b> tidak ditemukan!!!</div>',
	'</center>',
	'</div>'
];







var itemFrame	= [
	'<button id="card_item_', //idItem
	'" class="item-view col-xs-4 col-md-4 col-sm-4 col-lg-4 col-4" onclick="amountInclude(&#39;',//nameItem
		'&#39;, &#39;', //idItem
		'&#39;,', //amountItem
		',', //priceItem
	')">',
		'<div class="card-body card-item">',
			'<span id="amount_item_', //idItem
			'" class="image-label">', //amountItem
			'</span><img class="item-thumbnail" src="', //urlItem
			'">',	
			'<div class="col-12">',
				'<div class="float-left item-title">',
					'<span id="name_item_', //idItem
					'">', //nameItem
					'</span>',
				'</div>',
				'<br>',
				'<div class="float-right item-price">',
					'<b id="price_item_', //idItem
					'">', //priceItem
					'</b>',
				'</div>',
			'</div>',
		'</div>',
	'</button>',
	'<div class="row">',
	'</div>',
	'<center class="col-md-12"><div>Produk <b> : <u>',
	'</u></b> tidak ditemukan!!!</div>',
	'</center>'
];







var cartFrame = [
	'<tr id="cart_item_',//idItem
	'">',
		'<td>',	//nameItem
		'</td>',					
		'<td id="cart_amount_',//idItem
		'" class="number-right">', //amountItem
		'</td>',
		'<td class="number-right">', //priceItem
		'</td>',
		'<td id="cart_subtotal_',//idItem
		'" class="number-right">', //subtotal
		'</td>',
	'</tr>',
	'<tr id="cart_item_default"><td colspan="4"><b>Daftar Belanja</b> Kosong!!!</td></tr>'
];




var invoiceFrame = [
	'<tr id="invoice_item_', // idItem
		'">',
		'<td>', // nameItem
		'</td>',
		'<td class="number-right">', // priceItem
		' x ',	// amount
		'</td>',
		'<td class="number-right">', // subtotal
		'</td>',
	'</tr>',
	'</td></tr>',
	'<tr><td colspan="3">Total</td><td id="cart_total_" class="number-right">', //value
	'<tr><td colspan="3">Grand Total</td><td id="cart_final_" class="number-right">', //value
	'<tr id="customer"><td id="id_customer">Customer</td><td id="name_customer" colspan="3">', //value
	'<tr><td>Kasir</td><td colspan="3">', //value
	'<tr id="discount_cart_', //idDiscount 
	'"><td colspan="2">', //name Discount
	'</td><td id="discount_value_', //idDiscount
	'" class="number-right">-', //value
	'</td><td></td></tr>'
	
];









var discountFrame = [
	'<div id="discount_item_',
	'" class="col-md-12 col-sm-12 col-12">',
		'<div class="info-box bg-info discount">',
		'<div class="info-box bg-success discount">',
		'<div class="info-box bg-secondary discount">',
	'<span class="info-box-icon"><i class="fas fa-percent"></i></span>',
	'<div class="info-box-content"><span class="info-box-text">', //Bookmarks
	'</span>',
	'<span class="info-box-number">', //Rp. 101,010
	'</span>',
	'<div class="progress"><div class="progress-bar" style="width: 100%"></div></div>',
	'<span class="progress-description">', //70% Increase in 30 Days
	'</span></div>', //btn
	'</div></div>',
	'<div class="info-box-icon"><button class="btn btn-success btn-lg" onclick="chooseDiscount(&#39;',
	'&#39;)"> <span class="fas fa-check"></span></button></div>',
	'<div class="info-box-icon"><button class="btn btn-danger btn-lg" onclick="unchooseDiscount(&#39;',
	'&#39;)"> <span class="fas fa-check"></span></button></div>'
];