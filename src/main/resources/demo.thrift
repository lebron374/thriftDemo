namespace java com.thrift
const bool bDefault = true
const i32 iSmall = 1
const i64 iBig = 1
const double dBig = 1
const string demo = "demo"

enum ResultEnum {
	FAIL = 0,
	SUCCESS = 1
}


struct input {
	1:string param1,
	2:string param2,
	3:string action
}

struct output {
	1:ResultEnum result,
	2:string message
}


service Operation {
	output add(1:input param)
	output sub(1:input param)
	output alive()
	output divide(1:input param)
	output multiplication(1:input param)
}