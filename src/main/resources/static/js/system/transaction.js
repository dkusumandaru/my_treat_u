$(document).ready(function(){
	stop_loader();
	if (useItems.length == 0 || useItems[0].length == 0) {
		$( "#shop_cart" ).append(cartFrame[13]);
	}


	
	loadMember('hide');
	loadDiscount('hide');
	loadCart('hide');

	$('#paymentMethodForm').hide();

	executeGetItem();
	executeGetMember();
	getDiscount();
});

//---<> Control

	function loadCart(control){
		if (control == 'show') {
			$('#shoppingPanel').show();
			loadItem('hide');
		}else if(control == 'hide'){
			$('#shoppingPanel').hide();
			loadItem('show');
		}
	}

	function loadItem(control){
		if (control == 'show') {
			$('#itemPanel').show();
			$('#footer-cart').show();
		}else if(control == 'hide'){
			$('#itemPanel').hide();
			$('#footer-cart').hide();
		}
	}

	function loadMember(control){
		if (control == 'show') {
			$('#shoppingPanel').hide();
			$('#memberPanel').show();
			
		}else if(control == 'hide'){
			$('#memberPanel').hide();
			loadCart('show');
		}
		
	}

	function loadDiscount(control){
		if (control == 'show') {
			openDiscount();
			$('#shoppingPanel').hide();
			$('#discountPanel').show();	
		}else if(control == 'hide'){
			$('#discountPanel').hide();
			loadCart('show');
		}
	
	}

 
//---<> Control


//---<> Transanction
	var totalPayment = 0;
	var totalItem = 0;
	var payment = 0;

	function transaction(){
		var data = useItems;
		totalPayment = 0;
			for (var i = 0; i < data.length; i++) {
				var idItem = data[i].id_item;
				var nameItem = data[i].name_item;
				var priceItem = parseInt(data[i].sale_price);
				// var storeItem = data[i].item_store;
				var amount = $('#item_amount_'+idItem).val();
				if (amount > 0) {
					var amountItem = parseInt(amount);
					var subTotal = priceItem*amountItem;

					var invoiceFrameUsage=
						invoiceFrame[0]+idItem+
						invoiceFrame[1]+
						invoiceFrame[2]+nameItem+
						invoiceFrame[3]+
						invoiceFrame[4]+currencyFormater(priceItem)+
						invoiceFrame[5]+amountItem+
						invoiceFrame[6]+
						invoiceFrame[7]+currencyFormater(subTotal)+
						invoiceFrame[8]+
						invoiceFrame[9];

					totalPayment = totalPayment+subTotal;
					totalItem = totalItem+amountItem;

					$("#shop_invoice").append(invoiceFrameUsage);
					trueTemp.push('true');
				}else{
					$('#shoppingPanel').show();
					$('#itemPanel').show();
					$('#disountPanel').hide();
					
					
					falseTemp.push('false');
					alert('Kwantitas Produk : '+nameItem+' Kosong!!!');
				}
			}

	}



	function pushTransaction(){
		var accessTransaction;

			var chooseTransactionMethod = $('#chooseTransactionMethod').val();
			if (chooseTransactionMethod == 'transfer') {
				var noTransferMethod = $('#noTransferMethod').val();
				var nameTransferMethod = $('#nameTransferMethod').val();
				var valueTransferMethod = $('#valueTransferMethod').val();
					accessTransaction = {
						no : noTransferMethod,
						name : nameTransferMethod,
						value : valueTransferMethod,
						status : chooseTransactionMethod
					};
			}else if (chooseTransactionMethod == 'cash') {
				var payCashMethod = $('#payCashMethod').val();
				if (payCashMethod > 0 ) {
					var valueCashMethod = $('#valueCashMethod').val();
					var payCashMethod = $('#payCashMethod').val();
					var returnCashMethod = $('#returnCashMethod').val();
					accessTransaction = {
						value : valueCashMethod,
						pay : payCashMethod,
						return : returnCashMethod,
						status : chooseTransactionMethod
					};

				}else{
					alert('Jumlah Bayar Kosong!!!');
				}
			}

			var data = useItems;
			totalPayment = 0;
			var amountItems = {};
			for (var i = 0; i < data.length; i++) {
				var idItem = data[i].id_item;
				var priceItem = parseInt(data[i].sale_price);

				var amount = parseInt($('#cart_amount_'+idItem).text());
				var subTotal = priceItem*amount;
				amountItems[idItem] = { 
					amount : amount,
					price : priceItem,
					sub : subTotal

				};
			}
			
			if (useMember.length > 0) {
				var memberAccess = useMember;
			}else{
				var memberAccess = defaultMember;
			}

			if (useDiscount.length > 0) {
				var discountAccess = useDiscount;
			}else{
				var discountAccess = '-';
			}

			if (accessTransaction != '' && memberAccess.length > 0) {
				run_loader();
				var accessUrl = base_url+'transaction/create';


				var dataTransaction ={
					member 		:memberAccess,
					items 		:useItems,
					amounts		:amountItems,
					discounts 	:discountAccess 
				}

				$.ajax({
					type: 'POST',
					url	 : accessUrl,
					dataType : 'JSON',
					data :{accessTransaction: accessTransaction, dataTransaction: dataTransaction},
					success : function(data){
						if (data != false) {
							if (data.status == true) {
								destination = base_url+'transaction/invoice/'+data.transaction;
								stop_loader();
								var r = confirm("Transaksi Sukses...");
								if (r == true) {
									location.replace(destination);
								} else {
									location.replace(destination);
								}
							}
						}else{
							alert('Transaksi Gagal!!!');
						}
					}

		 
				});
			}else{
				alert('Transaksi invalid!!!');
			}
	}


	function calculate(){
		$('#shop_total').html('');
		$('#total_cart').html('');
		var data = useItems;
		totalPayment = 0;
		
		for (var i = 0; i < data.length; i++) {
			var idItem = data[i].id_item;
			var nameItem = data[i].name_item;
			var priceItem = parseInt(data[i].sale_price);
			var amountItem = parseInt($('#cart_amount_'+idItem).text());

				// var amountItem = parseInt(amount);
				var subTotal = priceItem*amountItem;

				var subtotal = parseInt($('#cart_subtotal_'+idItem).text());
				if (subTotal == subtotal) {
					totalPayment = totalPayment+subTotal;				
				}

		}
		var shop_total = invoiceFrame[11]+totalPayment+invoiceFrame[10];
		$('#shop_total').html(shop_total);
		

		var data = useDiscount;
		for (var i = 0; i < data.length; i++) {
			var idDiscount = data[i].id_discount;
			var nameDiscount = data[i].name_discount;
			var requiretypeDiscount = data[i].requiretype_discount;
			var requireDiscount = data[i].require_discount;
			var typeDiscount = data[i].type_discount;
			var valueDiscount = data[i].value_discount;
			var memberDiscount = data[i].member_discount;

				if (typeDiscount == 'percent') {
					var Discount = valueDiscount*totalPayment/100;
				}else if (typeDiscount == 'nominal') {
					var Discount = valueDiscount;
				}

				$('#discount_value_'+idDiscount).text('-'+Discount);

				totalPayment = totalPayment-Discount;

		}
		var total_cart = invoiceFrame[12]+totalPayment+invoiceFrame[10];
		$('#total_cart').html(total_cart);
		$('#price').text(totalPayment);
	}

	function reset(){
		
		useDiscount = [];
		useMember = [];
		useItems = [];
		$("#shop_cart").html('');
		$("#shop_total").html('');
		$("#discount_cart").html('');
		$("#total_cart").html('');
		$("#user_cart").html('');

		if (useItems.length == 0 || useItems[0].length == 0) {
			$( "#shop_cart" ).append(cartFrame[13]);
		}

		$('#price').text(0);

		
		
		
	}


//---<> Transanction

//---<> Transanction Method
	function transactionMethod(){
		$('#transactionMethod').modal('show');
		$('#transactionMethodControl').show();
		$('#cardTransferMethod').hide();
		$('#cardCashMethod').hide();
	}

	function chooseMethod(status){
		var payment = parseInt($('#cart_final_').text());
		if (status == 'transfer') {
			$('#paymentMethodForm').show();
			$('#cardTransferMethod').show();
			$('#chooseTransactionMethod').val(status);
			$('#transactionMethodControl').hide();
			$('#valueTransferMethod').val(payment);
		}else if (status == 'cash') {
			$('#paymentMethodForm').show();
			$('#cardCashMethod').show();
			$('#chooseTransactionMethod').val(status);
			$('#transactionMethodControl').hide();
			$('#valueCashMethod').val(payment);
		}
	}

	function executePay(){
		var valueCashMethod = parseInt($('#valueCashMethod').val());
		var payCashMethod = parseInt($('#payCashMethod').val());
		if (valueCashMethod != '' && payCashMethod != '') {
			if (payCashMethod >= valueCashMethod) {
				var returnCashMethod = payCashMethod-valueCashMethod;
				$('#returnCashMethod').val(returnCashMethod);
			}else{
				alert('Biaya '+payCashMethod+' transaksi tidak mencukupi!!!');
			}
		}else{
			alert('Biaya '+payCashMethod+' transaksi tidak mencukupi!!!');
		}
	}

	function clearPay(){
		$('#payCashMethod').val('');
		$('#returnCashMethod').val('');
	}
//---<> Transanction Method

//---<> test
	function testMember(){
		console.log('---------------<>');
		console.log('Result Search');
		console.log(resultMembers);
		console.log('---------------');
		console.log('Storage Member : ');
		console.log(useMember);
		console.log('Default Member : ');
		console.log(defaultMember);
		console.log('---------------');
		console.log('---------------<>');
		console.log('');
		console.log('');
	}

	function testItem(){
		console.log('---------------<>');
		console.log('Result Search');
		console.log(resultItems);
		console.log('---------------');
		console.log('Storage Item : ');
		console.log(useItems);
		console.log('---------------<>');
		console.log('');
		console.log('');
	}

	function testDiscount(){
		console.log('---------------<>');
		console.log('Result Search');
		console.log(resultDiscounts);
		console.log('---------------');
		console.log('Storage Discount : ');
		console.log(useDiscount);
		console.log('---------------');
		console.log('---------------<>');
		console.log('');
		console.log('');
	}
//---<> test