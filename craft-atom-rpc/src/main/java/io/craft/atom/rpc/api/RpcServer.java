package io.craft.atom.rpc.api;


/**
 * RPC server.
 * <p>
 * Use {@link RpcFactory} creates a rpc server and expose the remote interfaces or methods.
 * Last invoke {@link RpcServer#open()} to start the server to serve the rpc request from {@link RpcClient}.
 *  
 * @author mindwind
 * @version 1.0, Jul 30, 2014
 */
public interface RpcServer extends RpcServerMBean {
	
	/**
	 * Open the rpc server and get things going. 
	 * Just invoke this once.
	 */
	void open();
	
	/**
	 * Close the server, dispose all resources.
	 */
	void close();
	
	/**
	 * Export rpc interface. All the declared method in the interface are exported.
	 * 
	 * @param rpcInterface  exported rpc interface
	 * @param rpcObject     implementor object of rpc interface
	 * @param rpcParameter  behavioral parameter
	 */
	void export(Class<?> rpcInterface, Object rpcObject, RpcParameter rpcParameter);
	
	/**
	 * Export rpc interface and only the specific method in the interface is exported.
	 * 
	 * @param rpcInterface            exported rpc interface
	 * @param rpcMethodName           exported rpc method name
	 * @param rpcMethodParameterTypes exported rpc method parameter types
	 * @param rpcObject               implementor object of rpc interface
	 * @param rpcParameter            behavioral parameter
	 */
	void export(Class<?> rpcInterface, String rpcMethodName, Class<?>[] rpcMethodParameterTypes, Object rpcObject, RpcParameter rpcParameter);
	
	/**
	 * Export rpc interface with specific id. All the declared method in the interface are exported.
	 * 
	 * @param rpcId         identifier for rpc interface, if the rpc interface has multiple implementor object, set different rpc id.
	 * @param rpcInterface  exported rpc interface
	 * @param rpcObject     implementor object of rpc interface
	 * @param rpcParameter  behavioral parameter
	 */
	void export(String rpcId, Class<?> rpcInterface, Object rpcObject, RpcParameter rpcParameter);
	
	/**
	 * Export rpc interface with specific id. Only the specific method in the interface is exported.
	 * 
	 * @param rpcId                   identifier for rpc interface, if the rpc interface has multiple implementor object, set different rpc id.
	 * @param rpcInterface            exported rpc interface
	 * @param rpcMethodName           exported rpc method name
	 * @param rpcMethodParameterTypes exported rpc method parameter types
	 * @param rpcObject               implementor object of rpc interface
	 * @param rpcParameter            behavioral parameter
	 */
	void export(String rpcId, Class<?> rpcInterface, String rpcMethodName, Class<?>[] rpcMethodParameterTypes, Object rpcObject, RpcParameter rpcParameter);
	
	/**
	 * Unexport rpc interface specific method.
	 * 
	 * @param rpcInterface            exported rpc interface
	 * @param rpcMethodName           exported rpc method name
	 * @param rpcMethodParameterTypes exported rpc method parameter types
	 */
	void unexport(Class<?> rpcInterface, String rpcMethodName, Class<?>[] rpcMethodParameterTypes);
	
	/**
	 * Unexport rpc interface.
	 * 
	 * @param rpcInterface exported rpc interface
	 */
	void unexport(Class<?> rpcInterface);
	
	/**
	 * Unexport rpc interface witch specific id.
	 * 
	 * @param rpcId        identifier for rpc interface, if the rpc interface has multiple implementor object, set different rpc id.
	 * @param rpcInterface exported rpc interface
	 */
	void unexport(String rpcId, Class<?> rpcInterface);
	
	/**
	 * Unexport rpc interface with specific id. Only the specific method in the interface is unexported.
	 * 
	 * @param rpcId                   identifier for rpc interface, if the rpc interface has multiple implementor object, set different rpc id.
	 * @param rpcInterface            exported rpc interface
	 * @param rpcMethodName           exported rpc method name
	 * @param rpcMethodParameterTypes exported rpc method parameter types
	 */
	void unexport(String rpcId, Class<?> rpcInterface, String rpcMethodName, Class<?>[] rpcMethodParameterTypes);

}
