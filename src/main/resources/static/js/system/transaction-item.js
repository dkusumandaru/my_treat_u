//---<> Item
	var resultItems = [];
	var useItems = [];

	function executeSearchItem(){
		resultItems = [];
		var accessSearch = 'searchItem';
		var accessUrl = base_url+'transaction/search_item';

		if (accessSearch != '') {
			var valueSearch = $('#searchItem').val();
			$.ajax({
				type: 'POST',
				url   : accessUrl,
				dataType : 'JSON',
				data :{accessSearch: accessSearch, valueSearch: valueSearch},
				success : function(data){
					var items = '';
					resultItems.push(data);
					if (data != false) {
						for (var i = 0; i < data.length; i++) {
							var idItem = data[i].id_item;
							var nameItem = data[i].name_item;
							var priceItem = data[i].sale_price;
							var storeItem = data[i].item_store;
							var storeItem = data[i].item_store;


							var imageItem = data[i].image_item;
							var urlItem = '';
							if (imageItem != '') {
								urlItem = base_url+data[i].image_item;
							}else{
								urlItem = defaultImage;
							}
							
							
							var itemFrameUsage=		
									itemFrame[0]+idItem+
									itemFrame[1]+nameItem+
									itemFrame[2]+idItem+
									itemFrame[3]+storeItem+
									itemFrame[4]+priceItem+
									itemFrame[5]+
									itemFrame[6]+
									itemFrame[7]+idItem+
									itemFrame[8]+storeItem+
									itemFrame[9]+urlItem+
									itemFrame[10]+
									itemFrame[11]+
									itemFrame[12]+
									itemFrame[13]+idItem+
									itemFrame[14]+nameItem+
									itemFrame[15]+
									itemFrame[16]+
									itemFrame[17]+
									itemFrame[18]+
									itemFrame[19]+idItem+
									itemFrame[20]+priceItem+
									itemFrame[21]+
									itemFrame[22]+
									itemFrame[23]+
									itemFrame[24]+
									itemFrame[25];

							items += itemFrameUsage;

						}
						$('#items').html(items);
						// 
					}else{
						var itemFrameUsage = 
								memberFrame[0]+
								memberFrame[2]+
								itemFrame[28]+valueSearch+
								itemFrame[29]+
								itemFrame[30]+
								memberFrame[19]+
								memberFrame[20];

							// items = ;
						$('#items').html(itemFrameUsage);

					}
				}
			});
		}
	}

	function executeGetItem(){
		resultItems = [];
		var accessSearch = 'getItem';
		var accessUrl = base_url+'transaction/search_item';

		if (accessSearch != '') {
			var valueSearch = 'GET';
			$.ajax({
				type: 'POST',
				url   : accessUrl,
				dataType : 'JSON',
				data :{accessSearch: accessSearch, valueSearch: valueSearch},
				success : function(data){
					var items = '';
					resultItems.push(data);
					
					if (data != false) {
						for (var i = 0; i < data.length; i++) {
							var idItem = data[i].id_item;
							var nameItem = data[i].name_item;
							var priceItem = data[i].sale_price;
							var storeItem = data[i].item_store;


							var imageItem = data[i].image_item;
							var urlItem = '';
							if (imageItem != '') {
								urlItem = base_url+data[i].image_item;
							}else{
								urlItem = defaultImage;
							}
							
							var itemFrameUsage=		
									itemFrame[0]+idItem+
									itemFrame[1]+nameItem+
									itemFrame[2]+idItem+
									itemFrame[3]+storeItem+
									itemFrame[4]+priceItem+
									itemFrame[5]+
									itemFrame[6]+
									itemFrame[7]+idItem+
									itemFrame[8]+storeItem+
									itemFrame[9]+urlItem+
									itemFrame[10]+
									itemFrame[11]+
									itemFrame[12]+
									itemFrame[13]+idItem+
									itemFrame[14]+nameItem+
									itemFrame[15]+
									itemFrame[16]+
									itemFrame[17]+
									itemFrame[18]+
									itemFrame[19]+idItem+
									itemFrame[20]+priceItem+
									itemFrame[21]+
									itemFrame[22]+
									itemFrame[23]+
									itemFrame[24]+
									itemFrame[25];

							items += itemFrameUsage;

						}
						$('#items').html(items);
					}else{
						var itemFrameUsage = 
							itemFrame[0]+
							itemFrame[2]+
							itemFrame[19]+valueSearch+
							itemFrame[20]+
							itemFrame[21]+
							itemFrame[18];
							// items = ;
						$('#items').html(itemFrameUsage);

					}
				}
			});
		}
	}

	function clearSearchItem(){
		$('#items').html('');
		$('#searchItem').val('');
		resultItems = [];
		executeGetItem();
	}


	function amountItem(status){
		var stockItem = parseInt($('#stokAmountItem').val());
		var amountItem = parseInt($('#amountAmountItem').val());
		var priceItem = parseInt($('#priceAmountItem').val());

		if (stockItem != 0 && amountItem >= 0 && status == 'add') {
			var stockItemUpdate = stockItem-1;
			var amountItemUpdate = amountItem+1;
			var subtotalAmountItem = amountItemUpdate*priceItem;
			$('#subtotalAmountItem').val(subtotalAmountItem);		
			$('#stokAmountItem').val(stockItemUpdate);
			$('#amountAmountItem').val(amountItemUpdate);
		}else if (amountItem != 0 && stockItem >= 0 &&  status == 'remove') {
			var stockItemUpdate = stockItem+1;
			var amountItemUpdate = amountItem-1;
			var subtotalAmountItem = amountItemUpdate*priceItem;
			$('#subtotalAmountItem').val(subtotalAmountItem);
			$('#stokAmountItem').val(stockItemUpdate);
			$('#amountAmountItem').val(amountItemUpdate);
		}
	}


	function amountInclude(nameItem, idItem, stokItem, priceItem){
		if (stokItem == 0) {
			alert('Produk '+nameItem+' Stok Habis!!!');
		}else{
			// getSize();		

			var subtotal = $('#cart_subtotal_'+idItem).text();
			var amount = $('#cart_amount_'+idItem).text();

			if (subtotal != '' && amount != '') {
				var stok = stokItem-amount;
				$('#amountItem').modal('show');
				$('#nameAmountItem').val(nameItem);
				$('#idAmountItem').val(String(idItem));
				$('#priceAmountItem').val(priceItem);
				$('#stokAmountItem').val(stok);
				$('#amountAmountItem').val(amount);
				$('#subtotalAmountItem').val(subtotal);
			}else{
				$('#amountItem').modal('show');
				$('#nameAmountItem').val(nameItem);
				$('#idAmountItem').val(String(idItem));
				$('#priceAmountItem').val(priceItem);
				$('#stokAmountItem').val(stokItem);
				$('#amountAmountItem').val(0);
				$('#subtotalAmountItem').val(0);				
			}
		}
	}

	function pushCart(){
		$('#amountItem').modal('hide');
		// $('#nameAmountItem').val();
		// $('#priceAmountItem').val();
		// $('#stokAmountItem').val();
		var amountItem = $('#amountAmountItem').val();

		if (amountItem > 0) {
			var subtotal = $('#subtotalAmountItem').val();
			var idItem = $('#idAmountItem').val();
			var data = getDataId(idItem, 'item');
			var checkIdItem = checkDataId(idItem, 'item');


			if (checkIdItem == true) {
				if (useItems.length == 0 || useItems[0].length == 0) {
					$('#invoice').prop('disabled', false);
					$("#cart_item_default").remove();
					var nameUser = $('#nameUser').val();
					var user_cart = invoiceFrame[14]+nameUser+invoiceFrame[10];
					$('#user_cart').html(user_cart);
				}
				useItems.push(data);

				var idItem = data.id_item;
				var nameItem = data.name_item;
				var priceItem = data.sale_price;
				var storeItem = data.item_store;

				var cartFrameUsage = 
					cartFrame[0]+idItem+
					cartFrame[1]+
					cartFrame[2]+nameItem+
					cartFrame[3]+
					cartFrame[4]+idItem+
					cartFrame[5]+amountItem+
					cartFrame[6]+
					cartFrame[7]+priceItem+
					cartFrame[8]+
					cartFrame[9]+idItem+
					cartFrame[10]+subtotal+
					cartFrame[11]+
					cartFrame[12];



				$( "#shop_cart" ).append(cartFrameUsage);
				
			}else{

				var idItem = data.id_item;
				var nameItem = data.name_item;
				var priceItem = data.sale_price;
				var storeItem = data.item_store;

				var cartFrameUsage =
					cartFrame[2]+nameItem+
					cartFrame[3]+
					cartFrame[4]+idItem+
					cartFrame[5]+amountItem+
					cartFrame[6]+
					cartFrame[7]+priceItem+
					cartFrame[8]+
					cartFrame[9]+idItem+
					cartFrame[10]+subtotal+
					cartFrame[11];

				
				$("#cart_item_"+idItem).html(cartFrameUsage);
				
							
			}
		}else{
			alert('Jumlah Produk tidak boleh kosong!!!');
		}
		calculate();
	}

//---<> Item