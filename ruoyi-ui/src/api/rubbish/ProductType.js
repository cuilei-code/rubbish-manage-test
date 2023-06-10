import request from '@/utils/request'

// 查询商品分类列表
export function listProductType(query) {
  return request({
    url: '/rubbish/ProductType/list',
    method: 'get',
    params: query
  })
}

// 查询商品分类详细
export function getProductType(id) {
  return request({
    url: '/rubbish/ProductType/' + id,
    method: 'get'
  })
}

// 新增商品分类
export function addProductType(data) {
  return request({
    url: '/rubbish/ProductType',
    method: 'post',
    data: data
  })
}

// 修改商品分类
export function updateProductType(data) {
  return request({
    url: '/rubbish/ProductType',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function delProductType(id) {
  return request({
    url: '/rubbish/ProductType/' + id,
    method: 'delete'
  })
}
