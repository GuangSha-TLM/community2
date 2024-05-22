//代替vue2.0的兄弟组件通信bus
import mitt from "mitt";
const bus = mitt();
export default bus;