function getProductName() {
	var value = $('[name="idItemWholesale"]').val();
	if (value != null) {
		var name = $("select.form-control option[value="+value+"]").text();
		$("[name='nameItemWholesale']").val(name);
	}
}