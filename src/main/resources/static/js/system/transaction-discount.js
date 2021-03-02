var resultDiscounts = [];
var memberDiscounts = [];
var nonmemberDiscounts = [];
var useDiscount = [];

function getDiscount(){
	var accessDiscount = 'getDiscount';
	var accessUrl = base_url+'transaction/get_discount';
	$.ajax({
		type: 'POST',
		url   : accessUrl,
		dataType : 'JSON',
		data :{accessDiscount: accessDiscount},
		success : function(data){;
			resultDiscounts.push(data);
			
			var memberDiscount = '';
			var nonmemberDiscount = '';
			if (data != false) {
				for (var i = 0; i < data.length; i++) {
					var idDiscount = data[i].id_discount;
					var nameDiscount = data[i].name_discount;
					var requiretypeDiscount = data[i].requiretype_discount;
					var requireDiscount = data[i].require_discount;
					var typeDiscount = data[i].type_discount;
					var valueDiscount = data[i].value_discount;
					var memberDiscount = data[i].member_discount;

					if (memberDiscount == 'member') {
						memberDiscounts.push();
					}else if (memberDiscount == 'non-member') {
						nonmemberDiscounts.push();
					}
				}

			}
		}
	});
}

function countDiscount(data){
	var idDiscount = data.id_discount;
	var checkIdDiscount = checkDataId(idDiscount, 'discount');

	if (checkIdDiscount == true) {
		useDiscount.push(data);
		var idDiscount = data.id_discount;
		var nameDiscount = data.name_discount;
		var requiretypeDiscount = data.requiretype_discount;
		var requireDiscount = data.require_discount;
		var typeDiscount = data.type_discount;
		var valueDiscount = data.value_discount;
		var memberDiscount = data.member_discount;

		var payment = parseInt($('#cart_total_').text());
		var Discount = 0;
		if (typeDiscount == 'percent') {
			Discount = valueDiscount*payment/100;
		}else if (typeDiscount == 'nominal') {
			Discount = valueDiscount;
		}

		var invoiceFrameUsage=
			invoiceFrame[15]+idDiscount+
			invoiceFrame[16]+nameDiscount+
			invoiceFrame[17]+idDiscount+
			invoiceFrame[18]+Discount+
			invoiceFrame[19];

		$('#discount_cart').append(invoiceFrameUsage);
		calculate();
	}else{
		alert('Diskon telah digunakan!!!');
	}
}

function chooseDiscount(id){
	var data = getDataId(id, 'discount');
	countDiscount(data);
	$('#discount_item_'+data.id_discount).remove();
}

function openDiscount(){
	var data = resultDiscounts[0];
	var mDiscount ='';
	var nDiscount ='';
	if (useMember.length > 0) {
		var roleMember = useMember[0].role_member;
	}

	for (var i = 0; i < data.length; i++) {
		var idDiscount = data[i].id_discount;
		var nameDiscount = data[i].name_discount;
		var requiretypeDiscount = data[i].requiretype_discount;
		var requireDiscount = data[i].require_discount;
		var typeDiscount = data[i].type_discount;
		var valueDiscount = data[i].value_discount;
		var memberDiscount = data[i].member_discount;
		
		var checkIdDiscount = checkDataId(idDiscount, 'discount');

		if (checkIdDiscount == true) {

			if (requiretypeDiscount == 'piece') {
				var requirementDiscount = 'Minimal Pembelian : '+requireDiscount+' / pcs';
			}else if (requiretypeDiscount == 'nominal') {
				var requirementDiscount = 'Minimal Pembayaran : Rp. '+currencyFormater(requireDiscount);
			}

			if (typeDiscount == 'percent') {
				var Discount = String(valueDiscount)+' %';
			}else if (typeDiscount == 'nominal') {
				var Discount = 'Rp. '+currencyFormater(valueDiscount);
			}

			var totalPayment = parseInt($('#cart_total_').text());
			var totalItem = useItems.length;
			if (memberDiscount == 'member' && roleMember == memberDiscount) {
				if (requireDiscount < totalPayment && requiretypeDiscount == 'nominal' || requireDiscount < totalItem && requiretypeDiscount == 'piece') {

					// countDiscount(data[i]);
					var discountFrameUsage =
						discountFrame[0]+idDiscount+
						discountFrame[1]+
						discountFrame[2]+ // info
						// discountFrame[3]+ // success
						// discountFrame[4]+ // default
						discountFrame[5]+
						discountFrame[6]+nameDiscount+
						discountFrame[7]+
						discountFrame[8]+Discount+
						discountFrame[9]+
						discountFrame[10]+
						discountFrame[11]+requirementDiscount+
						discountFrame[12]+
						discountFrame[13];

						mDiscount += discountFrameUsage;

					chooseDiscount(idDiscount);
				}
			}else if (memberDiscount == 'non-member') {
				if (requireDiscount < totalPayment && requiretypeDiscount == 'nominal' || requireDiscount < totalItem && requiretypeDiscount == 'piece') {
					var discountFrameUsage =
						discountFrame[0]+idDiscount+
						discountFrame[1]+
						// discountFrame[2]+ // info
						discountFrame[3]+ // success
						// discountFrame[4]+ // default
						discountFrame[5]+
						discountFrame[6]+nameDiscount+
						discountFrame[7]+
						discountFrame[8]+Discount+
						discountFrame[9]+
						discountFrame[10]+
						discountFrame[11]+requirementDiscount+
						discountFrame[12]+
						discountFrame[14]+idDiscount+
						discountFrame[15]+
						discountFrame[13];
						
						nDiscount += discountFrameUsage;
				}
			}else{
				var discountFrameUsage =
					discountFrame[0]+
					discountFrame[1]+
					// discountFrame[2]+ // info
					// discountFrame[3]+ // success
					discountFrame[4]+ // default
					// discountFrame[5]+
					discountFrame[6]+'Diskon Tidak Tersedia'+
					discountFrame[7]+
					discountFrame[8]+
					discountFrame[9]+
					discountFrame[10]+
					discountFrame[11]+
					discountFrame[12]+
					// discountFrame[14]+idDiscount+
					// discountFrame[15]+
					discountFrame[13];

					mDiscount += discountFrameUsage;
					$('#member-discounts').html(mDiscount);
			}
		}
	}

	$('#member-discounts').html(mDiscount);
	$('#nonmember-discounts').html(nDiscount);
}