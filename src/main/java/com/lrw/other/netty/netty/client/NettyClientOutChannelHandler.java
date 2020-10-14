package com.lrw.other.netty.netty.client;

import com.lrw.algorithm.tree.TreeNode;
import io.netty.channel.*;

import java.net.SocketAddress;

public class NettyClientOutChannelHandler extends SimpleChannelInboundHandler<TreeNode> {



    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TreeNode treeNode) throws Exception {

    }
}
